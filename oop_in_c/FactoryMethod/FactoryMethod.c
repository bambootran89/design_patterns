#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#define MAX 100



void* *AllocatedObject[MAX];
int count = 0;
typedef struct Pizza Pizza;

struct Pizza{
	char name[100];
    char dough[100];
	char sauce[100];
    char toppings[MAX][100];
    int num;	
};
void Pizza_ctor(Pizza * const me,const char * const name_, const char * const dough_, const char * const sauce_){
	strcpy(me->name, name_);
	strcpy(me->dough, dough_);
    strcpy(me->sauce, sauce_);
	me->num = 0;
}

int  pizza_add(Pizza * const me, const char * const topping){
     strcpy(me->toppings[me->num], topping);
	 (me->num)++;

}
void pizza_prepare(Pizza * const me){
	int i;
	printf("Preparing ... %s\n", me->name);
	printf("Tossing dough ...\n",me->dough);
	printf("Adding sauce ...\n",me->sauce);
	printf("Adding topping: ");
    for(i =0; i<=me->num; i++)	
       printf(" %s", me->toppings[i]);

    printf("\n");
}
void pizza_bake(Pizza * const me){
	printf("Bake for 25 minutes at 350\n");

}

void pizza_cut(Pizza * const me){
	printf("Cutting the pizza into diagonal slices\n");

}
void pizza_box(Pizza * const me){
	printf("Place pizza on official PizzaStore box\n");

}

const char* const pizza_getName(Pizza * const me){
	return me->name;

}

typedef struct NYSTyleCheesePizza {
	Pizza super;

}NYSTyleCheesePizza; 

void NYSTyleCheesePizza_ctor( NYSTyleCheesePizza * const me, const char * const name_, const char * const dough_, const char * const sauce_){
	Pizza_ctor(&me->super,name_,dough_,sauce_);

	pizza_add(&me->super,"Granted Reffiano cheese");
}

typedef struct ChicagoStyleCheesePizza{
	Pizza super;

}ChicagoStyleCheesePizza; 

void ChicagoStyleCheesePizza_ctor( ChicagoStyleCheesePizza * const me, const char * const name_, const char * const dough_, const char * const sauce_){
	Pizza_ctor(&me->super,name_,dough_,sauce_);

	pizza_add(&me->super,"Granted Reffiano cheese");
}

typedef struct PizzaStore PizzaStore;
typedef struct PizTbl PizTbl;

struct PizTbl {
	Pizza * const  (*createPizza)(struct PizzaStore * const me, const char * const type);
};
struct PizzaStore{
    const PizTbl * vptr;
};

Pizza * const pizzaStore_orderPizza(PizzaStore * const me,  const char * const type_){
	 Pizza * const pizza = me->vptr->createPizza(me, type_);
	 if(pizza !=NULL) {
	 pizza_prepare(pizza);
	 pizza_bake(pizza);
	 pizza_cut(pizza);
	 pizza_box(pizza);
	 } else {

		 printf(" pizza =  null\n");
	 }
	 return pizza;
}

Pizza * const pizzaStore_createPizza(struct PizzaStore * const me,const char * const type){
	  return NULL;
}

void PizzaStore_ctor(PizzaStore * const me){
     static PizTbl const pizTbl = {

		 .createPizza = pizzaStore_createPizza
	 };

	 me->vptr = &pizTbl;

}

typedef struct ChicagoPizzaStore
{
  PizzaStore super;
}ChicagoPizzaStore;

static Pizza * const chicagoPizzaStore_createPizza(PizzaStore * const me, const char * const type){
     if(strcmp(type,"cheese") == 0) {
		  ChicagoStyleCheesePizza * const pizza = (ChicagoStyleCheesePizza *)malloc (sizeof(ChicagoStyleCheesePizza));
          ChicagoStyleCheesePizza_ctor(pizza,"chicago Style Deep Dish Cheese Pizza", "Extra Thin Crust Dough","Plum Tomato Sauce");
	      	  
          AllocatedObject[count++]= (void*)pizza;

		  return (Pizza * const) pizza;
	 }
     else return NULL;
}
void ChicagoPizzaStore_ctor(ChicagoPizzaStore * const me){
	static PizTbl const pizTbl = {

     	.createPizza = chicagoPizzaStore_createPizza
	};

	PizzaStore_ctor(&me->super);

	me->super.vptr = &pizTbl;
	
	
}

typedef struct NYPizzaStore
{
  PizzaStore super;
}NYPizzaStore;

static Pizza * const nyPizzaStore_createPizza(PizzaStore * const me, const char * const type){
     if(strcmp(type,"cheese") == 0) {
		  NYSTyleCheesePizza* const pizza = (NYSTyleCheesePizza * )malloc (sizeof(NYSTyleCheesePizza ));
          NYSTyleCheesePizza_ctor(pizza,"NY Style Sauce and Cheese Pizza", "Thin Crust Dough","Marrinara sauce");
	      	  
          AllocatedObject[count++]= (void*)pizza;
		  return (Pizza * const )pizza;
	 }else return NULL;

}
void NYPizzaStore_ctor(NYPizzaStore* const me){
	static PizTbl const pizTbl = {

      .createPizza =  nyPizzaStore_createPizza
	};

	PizzaStore_ctor(&me->super);

	me->super.vptr = &pizTbl;
	
	
}

int main(){
    
	NYPizzaStore nyStore;
	NYPizzaStore_ctor(&nyStore);

	Pizza * pizza;
	pizza = pizzaStore_orderPizza((PizzaStore * const )&nyStore, "cheese");
   
	printf(" Ethan ordered a %s\n",pizza_getName(pizza));
    
    ChicagoPizzaStore chicagoStore;
	ChicagoPizzaStore_ctor(&chicagoStore);

	Pizza * chipizza;
	chipizza = pizzaStore_orderPizza((PizzaStore * const )&chicagoStore, "cheese");
    
    printf(" Joel ordered a %s\n",pizza_getName(chipizza));
    //free
	for( ; count>-1; count--){
       free(AllocatedObject[count]);
	   
	}
  


return 0;
}
