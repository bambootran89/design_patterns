#include<stdio.h>
#include<string.h>

typedef struct Beverage Beverage;
typedef struct BeVtbl BeVtbl;

struct BeVtbl {
	double (*cost)(struct Beverage * const me);
};
typedef struct Beverage {
    const struct BeVtbl * vptr;
    char type;    
	char name[100];
}Beverage;

static double beverage_cost(Beverage * const me){
	return 0;
}

void Beverage_ctor(Beverage * const me, const char * const name_, const char t){
	static BeVtbl const vtbl= {

		.cost = beverage_cost
	};
    me->type=t; 
	me->vptr = &vtbl;
	strcpy(me->name, name_);

}

const char * const beverage_getDescription(Beverage * const me){
	return me->name;

}

typedef struct Espresso{
	struct Beverage  super;
}Espresso;

static double espresso_cost(Beverage * const me){
    //printf(" espresso cost"); 
	return 230.45;
}

void Espresso_ctor(Espresso * const me, const char * const name_){
	static BeVtbl const vtbl= {
		.cost = espresso_cost
	};
    Beverage_ctor(&me->super, name_,'b');
	me->super.vptr= &vtbl;
}

typedef struct HouseBlend{
	struct Beverage  super;
}HouseBlend;

static double houseblend_cost(Beverage * const me){
    //printf(" houseblend cost"); 
	return 23000.45;
}

void HouseBlend_ctor(HouseBlend * const me, const char * const name_){
	static BeVtbl const vtbl= {
		.cost = houseblend_cost
	};
    Beverage_ctor(&me->super, name_,'b');
	me->super.vptr= &vtbl;
}

typedef struct DarkRoast{
	struct Beverage  super;
}DarkRoast;

static double darkroast_cost(Beverage * const me){
    //printf("darkroast cost"); 
	return 23.54;
}

void DarkRoast_ctor(DarkRoast * const me, const char * const name_){
	static BeVtbl const vtbl= {
		.cost = darkroast_cost
	};
    Beverage_ctor(&me->super, name_,'b');
	me->super.vptr= &vtbl;
}

typedef struct Decaf{
	struct Beverage  super;
}Decaf;

static double decaf_cost(Beverage * const me){
    //printf("decaf cost"); 
	return 3.45;
}

void Decaf_ctor(Decaf * const me, const char * const name_){
	static BeVtbl const vtbl= {
		.cost = decaf_cost
	};
    Beverage_ctor(&me->super, name_,'b');
	me->super.vptr= &vtbl;
}

double cost(Beverage * const me){
     return (me->vptr->cost)(me);
}

typedef struct DecoVtbl DecoVtbl;
typedef struct CodimentDecorator CodimentDecorator;
struct DecoVtbl {
	void (*getDescription)(struct CodimentDecorator * const me, char * des);	
};

struct CodimentDecorator{
    Beverage super;
	const struct DecoVtbl * vptr;

};
void getDescriptionOfDecorator(Beverage * const me_, char * des);

static void codimentDecorator_getDescription(CodimentDecorator * const me_, char * des){
     strcat(des,beverage_getDescription(&me_->super));
}
static double codimentDecorator_cost(Beverage * const me){
	 return 0;
}

void CodimentDecorator_ctor(CodimentDecorator * const me, const char * const name_){
	 static DecoVtbl const  dvtbl = {
		 .getDescription = codimentDecorator_getDescription
	 };
     
	 static BeVtbl const vtbl= {
		.cost = codimentDecorator_cost
	 };
 
	 Beverage_ctor(&me->super,name_,'c');
     me->super.vptr = &vtbl;
	 me->vptr = &dvtbl;

}

typedef struct Milk{
    CodimentDecorator super;
	Beverage *beverage;
}Milk;

static void milk_getDescription(CodimentDecorator * const me_, char * des){
     Milk * const me = (Milk * const)me_;	

	//printf(" Milk getDescription\n");
    getDescriptionOfDecorator(me->beverage,des);
  
	strcat(des, " + Milk");
}
static double milk_cost(Beverage * const me_){
	Milk * const me = (Milk * const)me_;		
	
	return cost(me->beverage) + 45.23;
}
void Milk_ctor(Milk * const me, Beverage * const beverage_,const char * const name_){
	 static DecoVtbl const  dvtbl = {
		 .getDescription = milk_getDescription
	 };
     
	 static BeVtbl const vtbl= {
		.cost = milk_cost
	 };
 
	 CodimentDecorator_ctor(&me->super,name_);
     me->super.super.vptr = &vtbl;
	 me->super.vptr = &dvtbl;
	 me->beverage = beverage_;

}

typedef struct Mocha{
    CodimentDecorator super;
	Beverage *beverage;
}Mocha;

static void mocha_getDescription(CodimentDecorator * const me_, char * des){
    Mocha * const me = (Mocha * const)me_;	
	//printf(" mocha getDescription\n");
    getDescriptionOfDecorator(me->beverage,des);
	
	strcat(des, " + Mocha");
}
static double mocha_cost(Beverage * const me_){
	Mocha * const me = (Mocha * const)me_;		
	
	return cost(me->beverage) + 4.23;
}
void Mocha_ctor(Mocha * const me, Beverage * const beverage_,const char * const name_){
	 static DecoVtbl const  dvtbl = {
		 .getDescription = mocha_getDescription
	 };
     
	 static BeVtbl const vtbl= {
		.cost = mocha_cost
	 };
 
	 CodimentDecorator_ctor(&me->super,name_);
     me->super.super.vptr = &vtbl;
	 me->super.vptr = &dvtbl;
	 me->beverage = beverage_;

}

typedef struct Soy{
    CodimentDecorator super;
	Beverage *beverage;
}Soy;

static void soy_getDescription(CodimentDecorator * const me_, char * des){
    Soy * const me = (Soy * const)me_;	
	//printf(" soy getDescription\n");
    getDescriptionOfDecorator(me->beverage,des);
  
    strcat(des, " + Soy");
}
static double soy_cost(Beverage * const me_){
	Soy * const me = (Soy * const)me_;		
	
	return cost(me->beverage) + 123.23;
}
void Soy_ctor(Soy * const me, Beverage * const beverage_,const char * const name_){
	 static DecoVtbl const  dvtbl = {
		 .getDescription = soy_getDescription
	 };
     
	 static BeVtbl const vtbl= {
		.cost = soy_cost
	 };
 
	 CodimentDecorator_ctor(&me->super,name_);
     me->super.super.vptr = &vtbl;
	 me->super.vptr = &dvtbl;
	 me->beverage = beverage_;

}

typedef struct Whip{
    CodimentDecorator super;
	Beverage *beverage;
}Whip;

static void whip_getDescription(CodimentDecorator * const me_, char * des){
    Whip * const me = (Whip * const)me_;	
	//printf(" whip getDescription\n");
    getDescriptionOfDecorator(me->beverage,des);
  
    strcat(des, " + Whip");
}
static double whip_cost(Beverage * const me_){
	Whip * const me = (Whip * const)me_;		
	
	return cost(me->beverage) + 45.23;
}
void Whip_ctor(Whip * const me, Beverage * const beverage_,const char * const name_){
	 static DecoVtbl const  dvtbl = {
		 .getDescription = whip_getDescription
	 };
     
	 static BeVtbl const vtbl= {
		.cost = whip_cost
	 };
 
	 CodimentDecorator_ctor(&me->super,name_);
     me->super.super.vptr = &vtbl;
	 me->super.vptr = &dvtbl;
	 me->beverage = beverage_;

}



void getDescriptionOfDecorator(Beverage * const me_, char * des) {
    CodimentDecorator * const me = (CodimentDecorator * const)me_;
	if(me_->type=='c')
		(me->vptr->getDescription)(me,des);
	else 
		strcat(des,beverage_getDescription(me_));
}

int main (){
    char str[250];
	Espresso espresso; Espresso_ctor(&espresso, "Espresso");
	Beverage * const beverage = { 
        (Beverage * const ) &espresso	
	};
    
    str[0] = '\0';
	strcat(str, beverage_getDescription(beverage));

	printf(" %s with $%lf\n",str,cost(beverage));

	DarkRoast darkroast; DarkRoast_ctor(&darkroast, "DarkRoast");
	Beverage * beverage2 = {
        (Beverage * const ) &darkroast
	};

	Mocha mocha; Mocha_ctor(&mocha,beverage2,"Mocha");
    beverage2 = (Beverage * const ) &mocha;

	Mocha mocha1; Mocha_ctor(&mocha1,beverage2,"Mocha");
    beverage2 = (Beverage * const ) &mocha1;
    
	Whip whip; Whip_ctor(&whip,beverage2, "Whip");
	beverage2 = (Beverage * const) &whip;
   
	char str2[250];
    str2[0] = '\0';

	getDescriptionOfDecorator(beverage2, str2);
	printf(" %s with $%lf\n",str2,cost(beverage2));


	
return 0;
}
