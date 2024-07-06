#include <stdio.h>
#include <stdlib.h>

int main()
{
    int locks, stocks, barrels, t_sales;
    float commission;

    printf("Enter the total number of locks\n");
    scanf("%d", &locks);

    if (locks == -1)
    {
        printf("program ends\n");
        exit(0);
    }
    if ((locks <= 0) || (locks > 70))
    {
        printf("Values of locks not in range of 1...70\n");
        exit(0);
    }

    printf("Enter the total number of stocks\n");
    scanf("%d", &stocks);

    if ((stocks <= 0) || (stocks > 80))
    {
        printf("Values of stocks not in range of 1...80\n");
        exit(0);
    }

    printf("Enter the total number of barrels\n");
    scanf("%d", &barrels);

    if ((barrels <= 0) || (barrels > 90))
    {
        printf("Values of barrels not in range of 1...90\n");
        exit(0);
    }

    t_sales = (locks * 45) + (stocks * 30) + (barrels * 25);

    if (t_sales <= 1000)
    {
        commission = 0.10 * t_sales;
    }
    else if (t_sales < 1800)
    {
        commission = 0.10 * 1000;
        commission = commission + (0.15 * (t_sales - 1000));
    }
    else
    {
        commission = 0.10 * 1000;
        commission = commission + (0.15 * 800);
        commission = commission + (0.20 * (t_sales - 1800));
    }

    printf("The total sales is %d\n", t_sales);
    printf("The commission is %f", commission);
    return 0;
}
