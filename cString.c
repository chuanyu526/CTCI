#include "stdio.h"


//1.2
void reverseString( char s[] );

void main(){
    char s[] = "123456\n";
    printf("%s\n", s);
    reverseString(s);
    printf("%s\n",s);
}


void reverseString(char s[]){
    int i =0;
    char swap;
    while(s[i] != '\n'){
       i++;
    }
    for(int j=0, k=i-1 ; j <= i/2 ; j++, k--){
        swap = s[j];
        s[j] = s[k];
        s[k] = swap;
    }
}



