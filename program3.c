#include <stdio.h>
#include <stdlib.h>

int main(){
    int locks,stocks,barrels;
    float comission=0;
    int t_sales;

    while(1){
        printf("Enter the value of locks (-1 to end program):\n");
    scanf("%d",&locks);

    if(locks==-1){
        printf("Program ends\n");
        exit(0);
    }
    if(locks<=0 || locks>70)
    {
        printf("out of range : range(1-70)\n");
        continue;
    }
    printf("Enter the value of stocks:\n");
    scanf("%d",&stocks);


    if(stocks<=0 || stocks>80)
    {
        printf("out of range : range(1-80)\n");
        continue;
    }
    printf("Enter the value of barrels:\n");
    scanf("%d",&barrels);


    if(barrels<=0 || barrels>90)
    {
        printf("out of range : range(1-90)\n");
        continue;
    }
    printf("locks : %d\nstocks : %d\nbarrels : %d\n",locks,stocks,barrels);

    t_sales = (locks*45)+(stocks*30)+(barrels*25);
    printf("Total Sales is %d\n",t_sales);

    if(t_sales<=1000){
        comission = 0.10*t_sales;
    }
    else if(t_sales<1800){
        comission = 0.10*1000;
        comission = comission + (0.15 * (t_sales - 1000));
    }
    else {
        comission = 0.10*1000;
        comission = comission + (0.15 * 800);
        comission = comission + (0.20 * (t_sales - 1800));
    }

    printf("Total comission is : %.2f\n\n\n\n\n",comission);

    }
}
