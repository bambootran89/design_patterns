#include <stdio.h>
#include <string.h>
struct SolidObject{
  const struct SolidObject* super;
  void (*packageObject)(const struct SolidObject *me);
};

typedef struct {
    const struct SolidObject* pSolidObject;
	char name[100];
    int timelife;	
}Funiture;
static void funiture_packageObject(const struct SolidObject *me){
	Funiture * const me_ = (Funiture*)me;
	printf(" Putting Funiture %s to the van\n",me_->name);
}
void funiture_ctor(Funiture * const me, const char * const name_){
	static struct SolidObject const solidObject = {
		&solidObject,
		.packageObject = funiture_packageObject
	};
	me->pSolidObject = &solidObject;
    strcpy(me->name,name_);	
}

typedef struct {
    const struct SolidObject* pSolidObject;
    int isbn; 
	char name[100];
}Book;
static void book_packageObject(const struct SolidObject *me){
	Book * const me_ = (Book*)me;
	printf(" Putting Funiture %s to the van\n",me_->name);
}
void book_ctor(Book * const me, const char * const name_){
	static struct SolidObject const solidObject = {
		&solidObject,
		.packageObject = book_packageObject
	};
	me->pSolidObject = &solidObject;
    strcpy(me->name,name_);	
}



typedef struct Liquid {
	void (*packing)(const struct  Liquid *me);
    char name[100];
}Liquid;

static void liquid_packing(const Liquid *me){
	printf(" Pouring the liquid %s into a container for packaging into the van\n", me->name);
}

void liquid_ctor(Liquid * const me, const char * const name_){
	 me->packing = &liquid_packing;
     strcpy(me->name, name_);	 
}

typedef struct {
	const struct SolidObject* pSolidObject;
    char name[100];
    const Liquid * liquid;	
}LiquidAdapter;
static void liquid_packageObject(const struct SolidObject *me){
	LiquidAdapter * const me_ = (LiquidAdapter*)me;
    me_->liquid->packing(me_->liquid);
}
void liquidAdapter_ctor(LiquidAdapter * const me, const char * const name_,const Liquid * const liquid_){
	static struct SolidObject const solidObject = {
		&solidObject,
		.packageObject = liquid_packageObject
	};
	me->pSolidObject = &solidObject;
    strcpy(me->name,name_);
	me->liquid = liquid_;
}

static void packageObject(struct SolidObject * const me){
	me->super->packageObject(me);
}
int main(){
	int i;
	Book book;  book_ctor(&book,"book");
	Funiture funiture; funiture_ctor(&funiture,"funiture");

	Liquid liquid; liquid_ctor(&liquid,"liquid");

	LiquidAdapter liquidAdapter; liquidAdapter_ctor(&liquidAdapter,"liquidAdapter",&liquid);
	
	struct SolidObject * const solidObject[3] = {
		(struct SolidObject* const)&book,
		(struct SolidObject* const)&funiture,
     	(struct SolidObject* const)&liquidAdapter
	};
    
    
	for ( i = 0; i< 3; i++){
		packageObject(solidObject[i]);
	}
	
	
	return 0;
}
