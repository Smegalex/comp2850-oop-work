#include <stdlib.h>
#include <stdio.h>
#define MAX_LIMIT 100

void main()
{
	printf("Please enter your age: ");
	char buff[MAX_LIMIT];
	int age;
	fgets(buff, MAX_LIMIT, stdin);
	age = atoi(buff);
	printf("Your age is %d.\n", age);
}