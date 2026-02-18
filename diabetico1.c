#include <stdio.h>

int main(){
    char nome[100];
    int boulos, quantidadeInsulinaMaxima, carboidrato;
    int quantidadeInsulina, quantidadeMaximaCarboidrato, restanteInsulinaDia, restanteCarboidratoDia;


    printf("Ola! Informe seus dados.\n");
    printf("Nome: ");
    gets(nome);

    printf("Boulos Alimentar: ");
    scanf("%d", &boulos);

    printf("Quantidade de insulina maxima: ");
    scanf("%d", &quantidadeInsulinaMaxima);

    printf("Quantidade de carboidrato ingerido: ");
    scanf("%d", &carboidrato);

    quantidadeInsulina = (int) carboidrato / boulos;
    quantidadeMaximaCarboidrato = boulos * quantidadeInsulinaMaxima;
    restanteInsulinaDia = quantidadeInsulinaMaxima - quantidadeInsulina;
    restanteCarboidratoDia = quantidadeMaximaCarboidrato - carboidrato; 

    printf("Quantidade de insulina para essa refeicao: %d\n", quantidadeInsulina);
    printf("Quantidade maxima de carboidrato dia: %d\n", quantidadeMaximaCarboidrato);
    printf("Ainda restam %d unidades de insulina no dia\n", restanteInsulinaDia);
    printf("Ainda restam %d g de carboidrato no dia\n", restanteCarboidratoDia);
    
    

    return 0;
}