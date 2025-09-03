#include <stdio.h>
#include <string.h>

// M5 함수
void printRow(int (*row)[3]) {
    for (int i = 0; i < 3; i++) printf("%d ", (*row)[i]);
}

// M8 함수
void sum_row(int (*row)[4]) {
    int s = 0;
    for (int i = 0; i < 4; i++) {
        s += (*row)[i];
    }
    printf("%d", s);
}

// M9 함수
void to_uppercase(char (*words)[10], int n) {
    for (int i = 0; i < n; i++) {
        /* 한 행(문자열)의 전체 크기를 계산 */
        size_t len = sizeof(words[i]) / sizeof(words[i][0]);
        for (int j = 0; j < len; j++) {
            if (words[i][j] >= 'a' && words[i][j] <= 'z')
                words[i][j] -= 'a' - 'A';
        }
    }
}

int main() {
    printf("=== 포인터 배열 문제 (P1-P10) ===\n\n");
    
    // P1
    printf("P1 문제:\n");
    printf("char *arr[] = {\"one\", \"two\", \"three\"};\n");
    printf("printf(\"%%s\", arr[2]);\n");
    printf("[결과: ");
    char *arr1[] = {"one", "two", "three"};
    printf("%s]\n\n", arr1[2]);
    
    // P2
    printf("P2 문제:\n");
    printf("char *arr[] = {\"abc\", \"def\", \"ghi\"};\n");
    printf("printf(\"%%c\", *(arr[1] + 1));\n");
    printf("[결과: ");
    char *arr2[] = {"abc", "def", "ghi"};
    printf("%c]\n\n", *(arr2[1] + 1));
    
    // P3
    printf("P3 문제:\n");
    printf("int a[] = {10, 20, 30};\n");
    printf("int *p[3] = {&a[0], &a[1], &a[2]};\n");
    printf("printf(\"%%d\", *p[1]);\n");
    printf("[결과: ");
    int a3[] = {10, 20, 30};
    int *p3[3] = {&a3[0], &a3[1], &a3[2]};
    printf("%d]\n\n", *p3[1]);
    
    // P4
    printf("P4 문제:\n");
    printf("char *names[] = {\"Alice\", \"Bob\", \"Carol\"};\n");
    printf("for (int i = 0; i < 3; i++) printf(\"%%c \", *names[i]);\n");
    printf("[결과: ");
    char *names4[] = {"Alice", "Bob", "Carol"};
    for (int i = 0; i < 3; i++) printf("%c ]", *names4[i]);
    printf("\n\n");
    
    // P5
    printf("P5 문제:\n");
    printf("char *days[] = {\"Mon\", \"Tue\", \"Wed\", \"Thu\"};\n");
    printf("printf(\"%%s\", days[3] + 1);\n");
    printf("[결과: ");
    char *days5[] = {"Mon", "Tue", "Wed", "Thu"};
    printf("%s]\n\n", days5[3] + 1);
    
    // P6
    printf("P6 문제:\n");
    printf("int nums[] = {1,2,3,4,5};\n");
    printf("int *ptrs[5];\n");
    printf("for (int i = 0; i < 5; i++) ptrs[i] = &nums[i];\n");
    printf("int sum = 0;\n");
    printf("for (int i = 0; i < 5; i++) sum += *ptrs[i];\n");
    printf("printf(\"%%d\", sum);\n");
    printf("[결과: ");
    int nums6[] = {1,2,3,4,5};
    int *ptrs6[5];
    for (int i = 0; i < 5; i++) ptrs6[i] = &nums6[i];
    int sum6 = 0;
    for (int i = 0; i < 5; i++) sum6 += *ptrs6[i];
    printf("%d]\n\n", sum6);
    
    // P7
    printf("P7 문제:\n");
    printf("char *letters[] = {\"X\", \"Y\", \"Z\"};\n");
    printf("char **p = letters;\n");
    printf("printf(\"%%s %%s\", p[0], *(p+2));\n");
    printf("[결과: ");
    char *letters7[] = {"X", "Y", "Z"};
    char **p7 = letters7;
    printf("%s %s]\n\n", p7[0], *(p7+2));
    
    // P8
    printf("P8 문제:\n");
    printf("int a[] = {5, 10, 15};\n");
    printf("int *pa[] = { a, a+1, a+2 };\n");
    printf("int **ppa = pa;\n");
    printf("printf(\"%%d\", *ppa[2]);\n");
    printf("[결과: ");
    int a8[] = {5, 10, 15};
    int *pa8[] = { a8, a8+1, a8+2 };
    int **ppa8 = pa8;
    printf("%d]\n\n", *ppa8[2]);
    
    // P9
    printf("P9 문제:\n");
    printf("const char *strs[] = {\"apple\", \"banana\", \"cherry\"};\n");
    printf("char **p = (char **)strs;\n");
    printf("char ***pp = &p;\n");
    printf("printf(\"%%s\", pp[0][1]);\n");
    printf("[결과: ");
    const char *strs9[] = {"apple", "banana", "cherry"};
    char **p9 = (char **)strs9;
    char ***pp9 = &p9;
    printf("%s]\n\n", pp9[0][1]);
    
    // P10
    printf("P10 문제:\n");
    printf("int a[] = {7, 8, 9};\n");
    printf("int *pa[] = { &a[0], &a[1], &a[2] };\n");
    printf("int **ppa = pa;\n");
    printf("int ***ppp = &ppa;\n");
    printf("printf(\"%%d %%d\", *(*ppp)[0], *(*ppp)[2]);\n");
    printf("[결과: ");
    int a10[] = {7, 8, 9};
    int *pa10[] = { &a10[0], &a10[1], &a10[2] };
    int **ppa10 = pa10;
    int ***ppp10 = &ppa10;
    printf("%d %d]\n\n", *(*ppp10)[0], *(*ppp10)[2]);
    
    printf("=== 이차원 배열 문제 (M1-M10) ===\n\n");
    
    // M1
    printf("M1 문제:\n");
    printf("int arr[2][3] = {{1,2,3},{4,5,6}};\n");
    printf("int (*p)[3] = arr;\n");
    printf("printf(\"%%d\", p[1][2]);\n");
    printf("[결과: ");
    int arr_m1[2][3] = {{1,2,3},{4,5,6}};
    int (*p_m1)[3] = arr_m1;
    printf("%d]\n\n", p_m1[1][2]);
    
    // M2
    printf("M2 문제:\n");
    printf("int arr[3][2] = {{10,20},{30,40},{50,60}};\n");
    printf("for (int i = 0; i < 3; i++) printf(\"%%d \", *(*(arr + i) + 1));\n");
    printf("[결과: ");
    int arr_m2[3][2] = {{10,20},{30,40},{50,60}};
    for (int i = 0; i < 3; i++) printf("%d ]", *(*(arr_m2 + i) + 1));
    printf("\n\n");
    
    // M3
    printf("M3 문제:\n");
    printf("char mat[2][4] = {\"abc\",\"def\"};\n");
    printf("char (*p)[4] = mat;\n");
    printf("printf(\"%%c\", p[1][0]);\n");
    printf("[결과: ");
    char mat_m3[2][4] = {"abc","def"};
    char (*p_m3)[4] = mat_m3;
    printf("%c]\n\n", p_m3[1][0]);
    
    // M4
    printf("M4 문제:\n");
    printf("int arr[2][2] = {{1,2},{3,4}};\n");
    printf("int (*p)[2] = arr;\n");
    printf("int *q = arr[1];\n");
    printf("printf(\"%%d %%d\", p[0][1], *(q + 1));\n");
    printf("[결과: ");
    int arr_m4[2][2] = {{1,2},{3,4}};
    int (*p_m4)[2] = arr_m4;
    int *q_m4 = arr_m4[1];
    printf("%d %d]\n\n", p_m4[0][1], *(q_m4 + 1));
    
    // M5
    printf("M5 문제:\n");
    printf("void printRow(int (*row)[3]) {\n");
    printf("    for (int i = 0; i < 3; i++) printf(\"%%d \", (*row)[i]);\n");
    printf("}\n");
    printf("int a[2][3] = {{7,8,9},{10,11,12}};\n");
    printf("printRow(&a[0]); printf(\"\\n\"); printRow(&a[1]);\n");
    printf("[결과: ");
    int a_m5[2][3] = {{7,8,9},{10,11,12}};
    printRow(&a_m5[0]); printf(" / "); printRow(&a_m5[1]);
    printf("]\n\n");
    
    // M6
    printf("M6 문제:\n");
    printf("int arr[3][3] = {{0,1,2},{3,4,5},{6,7,8}};\n");
    printf("int (*p)[3] = arr + 2;\n");
    printf("for (int i = 0; i < 3; i++) printf(\"%%d \", (*p)[i]);\n");
    printf("[결과: ");
    int arr_m6[3][3] = {{0,1,2},{3,4,5},{6,7,8}};
    int (*p_m6)[3] = arr_m6 + 2;
    for (int i = 0; i < 3; i++) printf("%d ", (*p_m6)[i]);
    printf("]\n\n");
    
    // M7
    printf("M7 문제:\n");
    printf("char names[2][5] = {\"Ann\",\"Bob\"};\n");
    printf("char (*p)[5] = names;\n");
    printf("for (int i = 0; i < 2; i++) printf(\"%%s \", p[i]);\n");
    printf("[결과: ");
    char names_m7[2][5] = {"Ann","Bob"};
    char (*p_m7)[5] = names_m7;
    for (int i = 0; i < 2; i++) printf("%s ", p_m7[i]);
    printf("]\n\n");
    
    // M8
    printf("M8 문제:\n");
    printf("void sum_row(int (*row)[4]) {\n");
    printf("    int s = 0;\n");
    printf("    for (int i = 0; i < 4; i++) s += (*row)[i];\n");
    printf("    printf(\"%%d\\n\", s);\n");
    printf("}\n");
    printf("int matrix[3][4] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};\n");
    printf("sum_row(&matrix[1]);\n");
    printf("[결과: ");
    int matrix_m8[3][4] = {
        {1,  2,  3,  4},
        {5,  6,  7,  8},
        {9, 10, 11, 12}
    };
    sum_row(&matrix_m8[1]);
    printf("]\n\n");
    
    // M9
    printf("M9 문제:\n");
    printf("void to_uppercase(char (*words)[10], int n) {\n");
    printf("    for (int i = 0; i < n; i++) {\n");
    printf("        size_t len = sizeof(words[i]) / sizeof(words[i][0]);\n");
    printf("        for (int j = 0; j < len; j++) {\n");
    printf("            if (words[i][j] >= 'a' && words[i][j] <= 'z')\n");
    printf("                words[i][j] -= 'a' - 'A';\n");
    printf("        }\n");
    printf("    }\n");
    printf("}\n");
    printf("char list[3][10] = {\"apple\", \"Banana\", \"cherry\"};\n");
    printf("int rows = sizeof(list) / sizeof(list[0]);\n");
    printf("to_uppercase(list, rows);\n");
    printf("for (int i = 0; i < rows; i++) printf(\"%%s \", list[i]);\n");
    printf("[결과: ");
    char list_m9[3][10] = {"apple", "Banana", "cherry"};
    int rows_m9 = sizeof(list_m9) / sizeof(list_m9[0]);
    to_uppercase(list_m9, rows_m9);
    for (int i = 0; i < rows_m9; i++) {
        printf("%s ", list_m9[i]);
    }
    printf("]\n\n");
    
    // M10
    printf("M10 문제:\n");
    printf("int arr[2][4] = {{1,2,3,4},{5,6,7,8}};\n");
    printf("int (*p)[4] = arr + 1;\n");
    printf("size_t byte_offset = (char*)p - (char*)arr;\n");
    printf("int elem_idx = byte_offset / sizeof(int);\n");
    printf("printf(\"%%d\\n\", ((int*)arr)[elem_idx - 2]);\n");
    printf("[결과: ");
    int arr_m10[2][4] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8}
    };
    int (*p_m10)[4] = arr_m10 + 1;
    size_t byte_offset = (char*)p_m10 - (char*)arr_m10;
    int elem_idx = byte_offset / sizeof(int);
    printf("%d]\n", ((int*)arr_m10)[elem_idx - 2]);
    
    return 0;
}