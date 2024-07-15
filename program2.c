#include <stdio.h>
#include <stdlib.h>

int main() {
    int day, month, year;
    int tmday = 0, tmmonth = 0, tmyear = 0;
    int c1 = 0, c2 = 0, c3 = 0;

    printf("Enter today's date in the form of mm/dd/yyyy\n");
    scanf("%d/%d/%d", &month, &day, &year);

    tmmonth = month;
    tmday = day;
    tmyear = year;

    if(day >= 1 && day <= 31) c1 = 1;
    if(month >= 1 && month <= 12) c2 = 1;
    if(year >= 1823 && year <= 2023) c3 = 1;

    if(c1 && c2 && c3) {
        switch(month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                if(day < 31) tmday = day + 1;
                else if(day==31){
                    tmday = 1;
                    tmmonth = month + 1;
                }
                else {
                    printf("Invalid input\n");
                    return 1;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                if(day < 30) tmday = day + 1;
                else if(day == 30) {
                    tmday = 1;
                    tmmonth = month + 1;
                } else {
                    printf("Invalid input\n");
                    return 1;
                }
                break;

            case 12:
                if(day < 31) tmday = day + 1;
                else {
                    tmday = 1;
                    tmmonth = 1;
                    if(year == 2023) {
                        printf("Date out of range\n");
                        return 1;
                    }
                    tmyear = year + 1;
                }
                break;

            case 2:
                if(day < 28) tmday = day + 1;
                else if(day == 28) {
                    if(year % 4 == 0) tmday = 29;
                    else {
                        tmday = 1;
                        tmmonth = 3;
                    }
                } else if(day == 29) {
                    if(year % 4 == 0) {
                        tmday = 1;
                        tmmonth = 3;
                    } else {
                        printf("Invalid input\n");
                        return 1;
                    }
                } else {
                    printf("Invalid input\n");
                    return 1;
                }
                break;

            default:
                printf("Invalid input\n");
                return 1;
        }

        if (year == 2023 && month == 12 && day == 31) {
            printf("Date out of range\n");
        } else {
            printf("Next date is %d/%d/%d\n", tmmonth, tmday, tmyear);
        }
    } else {
        printf("Date out of range\n");
    }

    return 0;
}
