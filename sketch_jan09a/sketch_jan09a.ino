void setup() {  
Serial.begin(9600);  
  } 
  
void loop() { 
 if (Serial.available() > 0) 
{    
int inByte = Serial.read();      
switch (inByte) { 
   case '1':       
   digitalWrite(2, LOW);   
    break; 
   case '2': 
    digitalWrite(3, LOW);  
     break;  
   case '3':    
     digitalWrite(4, LOW);  
     break;  
 case '4':    
    digitalWrite(2, HIGH);    
  digitalWrite(3, HIGH);  
     digitalWrite(4, HIGH);     
      for (int thisPin = 2; thisPin <= 6; thisPin++)
 {     
   digitalWrite(thisPin, LOW); 
     }    }  } } 
