#include <stdio.h>

struct IButton{
	const struct IButton *super;
	void (*pain)(const struct IButton  *me);
};


struct IGUIFactory{
   const struct IGUIFactory *super;
   void (*createButton)(const struct IGUIFactory  *me, struct IButton * const button);
};

typedef struct {
	struct IButton const *pButton;
	int id;
}OSXButton;

static void osxButton_pain(const struct IButton *me) {
	OSXButton * const me_ = (OSXButton*)me;
	printf("paining OSXButton id = %d\n", me_->id );
}

void OSXButton_ctor(OSXButton * const me, int id_){
	static struct IButton const iButton = {
		 &iButton,
		.pain = osxButton_pain
	};
	
	me->pButton = &iButton;
	me->id = id_;	
}

static void osxFactory_createButton(const struct IGUIFactory  *me_, struct IButton * const button){
	   OSXButton_ctor((OSXButton*)button, 123);
};

typedef struct  {
	struct IGUIFactory const *pFactory;    
}OSXFactory;

void OSXFactory_ctor(OSXFactory * const me){
	static struct IGUIFactory const iGUIFactory = {
		&iGUIFactory,
		.createButton = osxFactory_createButton
	};
	me->pFactory = &iGUIFactory ;
}

typedef struct {
	struct IButton const *pButton;
	int id;
}WINButton;

void winButton_pain(const struct IButton  *me) {
	WINButton * const me_ = (WINButton*)me;
	printf("paining WINButton with id = %d \n", me_->id);
}
void WINButton_ctor(WINButton * const me, int id_){
	
	static struct IButton const iButton = {
		&iButton,
		.pain = winButton_pain
	};
	
	me->pButton = &iButton;
	me->id = id_;	
	
}

static void winFactory_createButton(const struct IGUIFactory  *me_, struct IButton * const button ){
	   WINButton_ctor((WINButton*)button, 321);
};

typedef struct{
    struct IGUIFactory const *pFactory;
}WINFactory;


void WINFactory_ctor(WINFactory * const me){
	static struct IGUIFactory iGUIFactory = {
		&iGUIFactory,
		.createButton = winFactory_createButton
	};
	me->pFactory = &iGUIFactory ;
}


static void button_pain(struct IButton* const me){
	   (me->super->pain)(me);
}

static void factory_createButton(struct IGUIFactory* const me, struct IButton * const button){	
	(me->super->createButton)(me, button);	
}


int main(){
    int i;
	WINFactory winFactory; 
	WINFactory_ctor(&winFactory);	
	
	OSXFactory osxFactory; 
	OSXFactory_ctor(&osxFactory);
	
	struct IGUIFactory*  factory[2] = {
		(struct IGUIFactory* ) &winFactory,
		(struct IGUIFactory* ) &osxFactory 
	};
	
	WINButton wButton;
	OSXButton osxButton;
	
	struct IButton *  button[2] = {
		(struct IButton * )&wButton, 
		(struct IButton * )&osxButton
	};
	
	for (i = 0; i < 2; i++) {		
		factory_createButton(factory[i],button[i]);
		button_pain(button[i]);
	}
	
	return 0;

}
