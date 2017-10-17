#!/bin/sh -e

echo "START"

file="/mnt/bootstrap/target/task-rest-service-0.1.0.jar"

if [ -f "$file" ]
then
	echo "$file found."
	java -jar $file &
	echo "Service rest started"
else
	echo "$file not found."
fi
echo "END"

exit

