#include <stdio.h>

int main() {
    int locks, stocks, barrels, tlocks = 0, tstocks = 0, tbarrels = 0;
    float lprice = 45.0, sprice = 30.0, bprice = 25.0;
    float lsales, ssales, bsales, sales, comm;

    printf("Enter the number of locks (-1 to end):\n");
    
    while (scanf("%d", &locks) == 1 && locks != -1) {
        if (locks < 0) {
            printf("Invalid input for locks. Please enter a non-negative number.\n");
            continue;
        }
        
        printf("Enter the number of stocks and barrels:\n");
        if (scanf("%d %d", &stocks, &barrels) != 2 || stocks < 0 || barrels < 0) {
            printf("Invalid input for stocks or barrels. Please enter non-negative numbers.\n");
            continue;
        }

        tlocks += locks;
        tstocks += stocks;
        tbarrels += barrels;

        printf("Enter -1 to end or enter the number of locks again:\n");
    }

    printf("Total locks sold: %d\n", tlocks);
    printf("Total stocks sold: %d\n", tstocks);
    printf("Total barrels sold: %d\n", tbarrels);

    lsales = lprice * tlocks;
    ssales = sprice * tstocks;
    bsales = bprice * tbarrels;
    sales = lsales + ssales + bsales;

    printf("Total sales: $%.2f\n", sales);

    if (sales > 1800.0) {
        comm = 0.10 * 1000.0 + 0.15 * 800.0 + 0.20 * (sales - 1800.0);
    } else if (sales > 1000.0) {
        comm = 0.10 * 1000.0 + 0.15 * (sales - 1000.0);
    } else {
        comm = 0.10 * sales;
    }

    printf("Commission earned: $%.2f\n", comm);

    return 0;
}
