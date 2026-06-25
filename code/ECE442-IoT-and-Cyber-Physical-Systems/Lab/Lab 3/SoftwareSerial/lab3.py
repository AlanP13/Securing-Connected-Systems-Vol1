import bluetooth # needed for bluetooth communication
import thingspeak # needed for thingspeak
 
bluetooth_addr = "00:20:12:08:2A:D8" # The address from the HC-06 sensor
bluetooth_port = 1 # Channel 1 for RFCOMM
bluetoothSocket = bluetooth.BluetoothSocket (bluetooth.RFCOMM)
bluetoothSocket.connect((bluetooth_addr,bluetooth_port))

#thingspeak information
channel_id = 1758168 # channel ID from your Thingspeak channel
key = "5CB3I11C59J5LTMY"  # obtain from Thingspeak
url = 'https://api.thinkspeak.com/update' # default URL to update Thingspeak
ts = thingspeak.Channel(channel_id, key, url)

while 1:
	try:
		received_data = bluetoothSocket.recv(1024)
		temperature = int.from_bytes(received_data,byteorder='big')
		print("Current Temperature: %d" % temperature)
		thingspeak_field1 = {"field1": temperature}
		ts.update(thingspeak_field1) # update thingspeak
		
	except KeyboardInterrupt:
		print("keyboard interrupt detected")
		break
bluetoothSocket.close()

