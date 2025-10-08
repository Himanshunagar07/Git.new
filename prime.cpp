// Online C++ compiler to run C++ program online
#include <iostream>
using namespace std;
int main() {
    int num;
    bool prime=true;
    
    cout<<"Enter the positive number:";
    cin>>num;
    
    if(num<=1){
        cout<<num<<" Number is not prime :"<<endl;
    return 0;
    }
    for(int i=2;i<=num/2;i++){
        if(num%i==0){
            prime=false;
            break;
        }
    }
    if(prime){
        cout<<num<<" Is prime number."<<endl;
    }else{
        cout<<num<<" Is not prime number."<<endl;
    }
    return 0;
}
