#include <stdio.h>
#include <stdlib.h>

int main() {
    int a, b, c;

    printf("Enter the values for the sides of the triangle\n");
    scanf("%d%d%d", &a, &b, &c);

    // Check if the input values are within the valid range
    if ((a < 1 || a > 10) || (b < 1 || b > 10) || (c < 1 || c > 10)) {
        printf("Invalid Input\n");
        return 1;
    }

    // Check if the input values can form a triangle
    if (a + b <= c || a + c <= b || b + c <= a) {
        printf("Triangle cannot be formed\n");
        return 1;
    }

    // Determine the type of triangle
    if (a == b && b == c) {
        printf("It is an Equilateral Triangle\n");
    } else if (a == b || b == c || c == a) {
        printf("It is an Isosceles Triangle\n");
    } else {
        printf("It is a Scalene Triangle\n");
    }

    return 0;
}
