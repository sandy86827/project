#include <SoftwareSerial.h> 
#include <Servo.h> 
Servo servoL; 
Servo servoR; 


int  photocellPinR = 1; 
int  photocellPinL = 0;
int  photocellPinC = 2;


int photocellValR = 0; 
int photocellValL = 0;
int photocellValC = 0;



int servoPinL = 11; 
int servoPinR = 12; 
 

char val; 
void setup() { 
Serial.begin(9600);

 
servoL.attach(servoPinL); 
servoL.writeMicroseconds(1500); 
servoR.attach(servoPinR); 
servoR.writeMicroseconds(1500); 

} 

void loop() { 


photocellValC = analogRead(photocellPinC);
photocellValR = analogRead(photocellPinR);
photocellValL = analogRead(photocellPinL);


Serial.print("左轉:");
Serial.print(photocellValL);
Serial.print("中間");
Serial.print(photocellValC);
Serial.print("右邊:");
Serial.println(photocellValR);


if(photocellValL -photocellValR>=0&& photocellValL -photocellValR <=20){
  /*if(photocellValC>=50&&photocellValC<=140){
     GoBack(30);
    }*/
  GoStraight(25);
  }else if(photocellValL -photocellValR<=20){
    GoLeft(100);
    }else if(photocellValL -photocellValR>=15) {
    GoRight(100);  
       }else{
          GoStop();
       }
       }
       
void GoStraight(int speed) 
{ 
int offset = speed * 0.6; 
servoL.writeMicroseconds(1500 + (speed*2)-offset); 
servoR.writeMicroseconds(1500 - (speed*2)+offset); 
} 

void GoBack(int speed) 
{ 
servoL.writeMicroseconds(1500 - (speed*2)); 
servoR.writeMicroseconds(1500 + (speed*2)); 
} 

void GoLeft(int speed) 
{ 
servoL.writeMicroseconds(1440);
servoR.writeMicroseconds(1500 - (speed*2));
} 

void GoRight(int speed) 
{   
servoL.writeMicroseconds(1500 + (speed*2));
servoR.writeMicroseconds(1560);
} 

void GoStop() 
{  
servoL.writeMicroseconds(1500); 
servoR.writeMicroseconds(1500); 
}




 






