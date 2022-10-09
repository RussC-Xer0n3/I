/**
 * The contents of the file here for all intents of purpose
 * are to copy data from one text file into a structured xml
 * of key to value pairs.
 * 
 * @author - Russell. A. E. Clarke
 * @date - 12/09/2022
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main() {

    FILE in = fopen("words_alpha.txt", "r");
    char buff[33];

    if (!in) {

        printf("Cannot open file %s \n", in);
        exit(0);

    } else {

        while (in != EOF && fgets(buff, 32, a) != NULL) {
            parser(&buff);
        }

        fclose(in);

    }   

    return 0;
}

int parser(char *a) {

    FILE dictionary = fopen("dictionary.xml", "w");

    char buff[33];

    for (int i = 0; i <= strlen(&a)-1; i++) {
        strcpy(buff, a[i]);
    }

    do {
        fputs(("<key_val\r\t\tandroid:name=\"%s\"\r\t\tandroid:value=\"%s\" />\r", &buff, &buff), dictionary);
    } while (buff != NULL);

    fclose(dictionary);

    return 0;
}