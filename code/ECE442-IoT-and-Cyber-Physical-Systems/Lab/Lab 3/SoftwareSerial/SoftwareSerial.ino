#include <SoftwareSerial.h>
#include "dht.h"

SoftwareSerial mySerial(5, 6); // RX, TX
#define DHT_Sensor 7
dht sensor;

void setup() {
  // Open serial communications and wait for port to open:
  Serial.begin(9600);
  mySerial.begin(38400);
}

void loop() { // run over and over
  sensor.read11(DHT_Sensor);
  float tc=sensor.temperature;
  float tf=tc*1.8+32;
  Serial.print(tc);
  Serial.print("C (");
  Serial.print(tf);
  Serial.print("F)\t");
  mySerial.write(tf);
  Serial.println("Bluetooth Transmission Complete");
  Serial.flush();
  delay(1000);
}
