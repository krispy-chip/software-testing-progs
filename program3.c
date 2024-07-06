#include <stdio.h>
#include <stdlib.h>

int main()
{
    int locks, stocks, barrels, t_sales;
    float commission;

    while(1) {
        // Prompt for the total number of locks
        printf("Enter the total number of locks (-1 to end):\n");
        scanf("%d", &locks);

        // Check for end condition
        if (locks == -1) {
            printf("Program ends\n");
            break;
        }

        // Validate locks input
        if ((locks <= 0) || (locks > 70)) {
            printf("Values of locks not in range of 1...70\n");
            continue;
        }

        // Prompt for the total number of stocks
        printf("Enter the total number of stocks:\n");
        scanf("%d", &stocks);

        // Validate stocks input
        if ((stocks <= 0) || (stocks > 80)) {
            printf("Values of stocks not in range of 1...80\n");
            continue;
        }

        // Prompt for the total number of barrels
        printf("Enter the total number of barrels:\n");
        scanf("%d", &barrels);

        // Validate barrels input
        if ((barrels <= 0) || (barrels > 90)) {
            printf("Values of barrels not in range of 1...90\n");
            continue;
        }

        // Calculate total sales value
        t_sales = (locks * 45) + (stocks * 30) + (barrels * 25);

        // Calculate commission based on total sales
        if (t_sales <= 1000) {
            commission = 0.10 * t_sales;
        } else if (t_sales < 1800) {
            commission = 0.10 * 1000;
            commission += 0.15 * (t_sales - 1000);
        } else {
            commission = 0.10 * 1000;
            commission += 0.15 * 800;
            commission += 0.20 * (t_sales - 1800);
        }

        // Display the total sales and commission
        printf("The total sales is %d\n", t_sales);
        printf("The commission is %.2f\n", commission);
    }

    return 0;
}
