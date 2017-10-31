#include<stdlib.h>
#include<stdio.h>
#include<string.h>
#define MAX 100

typedef struct Observer Observer;
typedef struct Observable Observable;

struct Observable {
   const struct Observable * const this;
   void (*addObserver)(struct Observable * const me, struct Observer * const ob);
   void (*deleteObserver)(struct Observable * const me, struct Observer * const ob);
   void (*notifyObserver)(struct Observable * const me);
   void (*setChanged)(struct Observable * const me,double tem, double hum, double press);
   void (*getInfo)(struct Observable * const me, char * const str);
};


void addObserver(struct Observable * const me, struct Observer * const ob){
	me->this->addObserver(me,ob);
}
void deleteObserver (struct Observable * const me, struct Observer * const ob){
   me->this->deleteObserver(me,ob);
}

void setChanged(struct Observable * const me, double tem, double hum, double press){
	me->this->setChanged(me,tem, hum, press);
}
struct Observer {
	const struct Observer * const this;
	void (*update)(struct Observer * const me,struct Observable * const ob);	
};


void update(struct Observer * const me,struct Observable * const ob){
	me->this->update(me,ob);

}

typedef struct WeatherData{
	const Observable * super; 
    Observer* lists[MAX];
    int numLists;
	double temperature;
	double humidity;
	double pressure;

}WeatherData;

void weatherData_addObserver( Observable* const me_, Observer * const ob_){
	WeatherData * const me =  (WeatherData * const) me_;
	me->lists[(me->numLists)] = ob_;
    (me->numLists)++;
}

void weatherData_deleteObserver( Observable* const me_, Observer * const ob_){
    /* do it yourself */

}

void weatherData_notifyObserver(Observable* const me_){
	WeatherData * const me = (WeatherData * const) me_;

	int i;
	for( i =0 ; i< me->numLists; i++){
       update(me->lists[i], me_);	
    }

}
void weatherData_setChanged(Observable * const me_,double tem, double hum, double pres){
     WeatherData * const me = (WeatherData * const) me_;

	 me->temperature = tem;
	 me->humidity = hum;
	 me->pressure = pres;
	 weatherData_notifyObserver(me_);
}


void weatherData_getInfo(Observable * const me_, char * const str){
	WeatherData * const me = (WeatherData * const) me_;
    snprintf(str,100,"temperature %lf humidity %lf pressure %lf ",me->temperature,me->humidity,me->pressure);

}

void WeatherData_ctor(WeatherData * const me){
    static Observable const ob = {
      &ob,
      .addObserver = weatherData_addObserver,
      .deleteObserver = weatherData_deleteObserver,
      .notifyObserver = weatherData_notifyObserver,
      .setChanged = weatherData_setChanged,
  	  .getInfo = weatherData_getInfo	  
	};

	me->super = &ob;
	me->numLists = 0;
}

typedef struct  GeneralDisplay{
    const Observer *super;
}GeneralDisplay;

void generalDisplay_update(Observer * const me,Observable *const ob){
     char display[100];
	 ob->this->getInfo(ob,display);
	 printf(" Updating for GeneralDisplay with %s\n", display);

}

void GeneralDisplay_ctor(GeneralDisplay * const me)
{
	static Observer const ob = {
       &ob,
	   .update = generalDisplay_update
	};
	me->super = &ob;
}

typedef struct  ForecastDisplay{
    const Observer *super;
}ForecastDisplay;

void forecastDisplay_update(Observer * const me,Observable *const ob){
     char display[100];
	 ob->this->getInfo(ob,display);
	 printf(" Updating for ForecastDisplay with %s\n", display);

}

void ForecastDisplay_ctor(ForecastDisplay * const me)
{
	static Observer const ob = {
       &ob,
	   .update = forecastDisplay_update
	};
	me->super = &ob;
}

typedef struct  StatisticDisplay{
    const Observer *super;
}StatisticDisplay;

void statisticDisplay_update(Observer * const me,Observable *const ob){
     char display[100];
	 ob->this->getInfo(ob,display);
	 printf(" Updating for StatisticDisplay with %s\n", display);

}

void StatisticDisplay_ctor(StatisticDisplay * const me)
{
	static Observer const ob = {
       &ob,
	   .update = statisticDisplay_update
	};
	me->super = &ob;
}

int main(){
    WeatherData weatherData; WeatherData_ctor(&weatherData);
	ForecastDisplay ob1; ForecastDisplay_ctor(&ob1);
	StatisticDisplay ob2; StatisticDisplay_ctor(&ob2);
	GeneralDisplay ob3; GeneralDisplay_ctor(&ob3);
    
	addObserver((Observable * const) &weatherData,(Observer * const) &ob1);
	addObserver((Observable * const) &weatherData,(Observer * const) &ob2);
    addObserver((Observable * const) &weatherData,(Observer * const) &ob3);
    
	setChanged((Observable * const) &weatherData, 34.0, 89.78, 1.34);

	return 0;
}
