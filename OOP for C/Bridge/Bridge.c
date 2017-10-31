#include<stdio.h>
#include<string.h>

typedef struct TV TV;
typedef struct TVVtbl TVVtbl;

struct TVVtbl{
	void (*turnChannel)( struct  TV * const me, int channel);
};

struct TV{
 	struct TVVtbl const *vptr; 
	int inch;

};


void tv_on(struct TV * const me){
	(me->inch)++; /* this is an example for being aware of const*/
	(me->inch)--; /* this is an example for being aware of const*/

	printf(" Turning on the TV %d inch\n",me->inch);
}

void tv_off(struct TV * const me){
	(me->inch)++;/* this is an example for being aware of const*/
	(me->inch)--;/* this is an example for being aware of const*/

	printf(" Turning off the TV %d inch\n",me->inch);
}

static void tv_turningChannel(struct TV * const me, int channel){
	//ASSERT(0);
	return;
}
void TV_ctor(struct TV * const me, int inch_)
{
   static struct TVVtbl const vtbl = {
		.turnChannel = tv_turningChannel
   };
   me->vptr = &vtbl; 
   me->inch = inch_;

}

struct Sony{
	struct	TV super;

	char name[100];
};


static void sony_turningChannel(struct TV * const me, int channel){
    struct Sony * const me_ = (struct Sony*) me;	
	printf(" Processing turning channel to %d for %s\n", channel, me_->name);
}

void Sony_ctor(struct Sony * const me, int inch, char * name_){
	static struct TVVtbl const vtbl = {
		.turnChannel = sony_turningChannel	
	};
	TV_ctor(&me->super, inch);
	me->super.vptr=&vtbl;

	strcpy(me->name, name_);

}

struct RCATv{
	struct	TV super;

	char name[100];
};


static void rcatv_turningChannel(struct TV * const me, int channel){
    struct RCATv * const me_ = (struct RCATv*)me;	
	printf(" Processing turning channel to %d for %s\n", channel, me_->name);
}

void RCATv_ctor(struct RCATv * const me, int inch, char * name_){
	static struct TVVtbl const vtbl = {
		.turnChannel = rcatv_turningChannel	
	};
	TV_ctor(&me->super, inch);
	me->super.vptr=&vtbl;

	strcpy(me->name, name_);

}

struct RemoteControl{
	struct TV *  implementor;
};
void RemoteControl_ctor(struct RemoteControl * const me, struct TV * const imp ){
    me->implementor = imp;	
}
void on(struct RemoteControl * const me){
	 tv_on(me->implementor);
}
void off(struct RemoteControl * const me){
	 tv_off(me->implementor);
}
void setChannel(struct RemoteControl * const me, int channel){
	struct TV * const me_ = me->implementor; 
	me_->vptr->turnChannel(me_, channel);
}

struct ConcreateRemote {
	struct RemoteControl super;
    int currentStation;
};

void ConcreateRemote_ctor(struct ConcreateRemote * const me, struct TV * const imp, int channel){
   RemoteControl_ctor(&me->super, imp);

   me->currentStation = channel;

}

void nextChannel(struct RemoteControl * const me_){
    struct ConcreateRemote * const me = (struct ConcreateRemote * const)me_;	
    if(me->currentStation==200) printf("can not set the next channel because it is max\n");

	else setChannel(&me->super,++(me->currentStation));

}

void previousChannel(struct RemoteControl * const me_){
	struct ConcreateRemote * const me = (struct ConcreateRemote * const)me_;
	if(me->currentStation==100) printf("can not set the next channel because it is min\n");

	else setChannel(&me->super,--(me->currentStation));

}

void concreate_setChannel(struct RemoteControl* const me_, int channel){
    struct ConcreateRemote * const me = (struct ConcreateRemote * const)me_;
	if (channel<=200&& channel >=100){
       setChannel(&me->super, channel);
	   me->currentStation = channel;
	}else {
	   printf(" can not set that channel because it is out of the range from 100 to 200\n");
	}
}

int main(){
    int i; 
	struct Sony sony; 
    Sony_ctor(&sony, 21, "Prime Sony");
    struct RCATv rcaTv;
	RCATv_ctor(&rcaTv, 40, "RCATv");

    struct TV * const tv[2] = {
          (struct TV * const) &sony,
		  (struct TV * const) &rcaTv
	};
    
	
	struct ConcreateRemote concreateRemoteforSony;
	ConcreateRemote_ctor(&concreateRemoteforSony,tv[0], 120);
	struct ConcreateRemote concreateRemoteforRCATv;
	ConcreateRemote_ctor(&concreateRemoteforRCATv, tv[1],141);
    
    struct RemoteControl * const remoteControl[2] = {
		(struct RemoteControl * const) &concreateRemoteforSony,
		(struct RemoteControl * const) &concreateRemoteforRCATv
	};


    int input;
	for ( i = 0; i< 2; i++){
		on(remoteControl[i]);
        
		printf(" please input the number from 100 to 200 for setting channel: ");

		while(1){

			scanf("%d", &input);
			if(input>= 100 && input <=200) break;
			else {

				 printf(" the number is out of range from 100 to 200 so try again ...: ");
			}
	    
		}
	    
		concreate_setChannel(remoteControl[i], input);

		nextChannel(remoteControl[i]);

		previousChannel(remoteControl[i]);

		off(remoteControl[i]);
	}
   

	return 0;
}
