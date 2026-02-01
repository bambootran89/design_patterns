#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX 100
typedef struct BillingStrategy {
     const struct BillingStrategy * const this;
     double (*getActPrice)(struct BillingStrategy * const me, double rawPrice);
}BillingStrategy;

typedef struct HappyHourStrategy{
    const BillingStrategy * super;
	double discount;
}HappyHourStrategy;

static double  happyHourStratery_getActPrice(BillingStrategy * const me_, double rawPrice){
      HappyHourStrategy * const me = (HappyHourStrategy * const) me_;
	  return rawPrice * me->discount;
}

void HappyHourStrategy_ctor(HappyHourStrategy * const me, double discount_){
	static BillingStrategy const billingStratery = {
        &billingStratery,
		.getActPrice = happyHourStratery_getActPrice
	};
    me->super = &billingStratery;
	me->discount = discount_;
}

typedef struct NormalStrategy{
    const BillingStrategy * super;
}NormalStrategy;

static double  normalStratery_getActPrice(BillingStrategy * const me_,double rawPrice ){
	  return rawPrice;
}

void NormalStrategy_ctor(NormalStrategy * const me){
	static BillingStrategy const billingStratery = {
        &billingStratery,
		.getActPrice = normalStratery_getActPrice
	};
    me->super = &billingStratery;
}

double getActPrice(BillingStrategy * const me,double rawPrice){
       return me->this->getActPrice(me, rawPrice);
}
typedef struct Customer {
	double list[MAX];
	int numList;
	BillingStrategy *strategy;
}Customer;

void Customer_ctor(Customer * const me,BillingStrategy * const strategy_){
	me->strategy = strategy_;
	me->numList = 0;
}
void customer_add(Customer * const me, double price, int qualities){
	me->list[(me->numList)++] = getActPrice(me->strategy, price)*qualities;
}

void customer_set(Customer * const me, BillingStrategy * const strategy_){
	me->strategy = strategy_;
}


double Customer_getSum(Customer * const me){
    double sum = 0;
    int i = 0;
    for(i = 0; i < me->numList; i++){
		sum += me->list[i];
	}
    return sum;
}

void customer_printBill(Customer * const me){
    double sum = 0;
    int i = 0;
    for(i = 0; i < me->numList; i++){
		sum += me->list[i];
	}

	printf(" Total due: %lf\n", sum);
	me->numList = 0;
}
main(){

	HappyHourStrategy happyStrategy; HappyHourStrategy_ctor(&happyStrategy,0.5);

	NormalStrategy normalStrategy; NormalStrategy_ctor(&normalStrategy);
    Customer a; Customer_ctor(&a,(BillingStrategy * const)&normalStrategy);

	customer_add(&a, 1.0, 1);

	customer_set(&a,(BillingStrategy * const )&happyStrategy);

	customer_add(&a,1.0, 2);

    Customer b; Customer_ctor(&b,(BillingStrategy * const)&happyStrategy);
    
    customer_add(&b, 0.8, 1);

	customer_set(&b,(BillingStrategy * const) &normalStrategy);

	customer_add(&b, 1.3, 2);
	customer_add(&b, 2.5, 1);


	customer_printBill(&a);

	customer_printBill(&b);


	return 0;
}

