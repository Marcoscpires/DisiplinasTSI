x <- c(-0.4, -2.8, 9.7, 6.3, 5.6, 6.5, 10.6, 10.7, 6.6, 10.0, -0.2, 5.6, -3.8, -2.0, 1.3,
2.8, 5.8, 11.1, 1.4, 3.0, 2.9, 11.4, 5.6, 5.1, 5.3, 2.8, 3.3, 4.5, 4.1, 5.4,
3.5, 1.6, -5.0, -2.4, 6.0, -1.2, 6.7, 4.4, 8.9, -0.9, 7.0, 0.5, 4.0, 4.9, 7.2)

#a)
#média
x_sum <- sum(x)
x_len <- length(x)
c(x_sum, x_len)

#soma: 183.4 
#count: 45

x_med <- x_sum/x_len
x_med

#Média: 4.075556

#mediana
x_mediana <- median(x)
x_mediana

#Mediana: 4.5

#moda
x_tab <- as.matrix(table(x))
x_mod <- subset(x_tab, x_tab == max(x_tab))
x_mod


#Moda: 5.6  aparece 3 vezes

#b)
#variança
x_var <- var(x)
x_var

#Variança: 16.87916

#desvio padrão:
x_sd <- sd(x)
x_sd

#Desvio padrão: 4.108426

#coeficiente de variação:
x_cv <- sd(x)/mean(x)*100
x_cv

#Coeficiente de Variação: 100.8065

#c)
#quartis
x_qua <- quantile(x)
x_qua

# 0%  25%  50%  75% 100%
#-5.0  1.4  4.5  6.5 11.4
#Q1 = 1.4 / Q2 = 4.5 / Q3 = 6.5


#limites superior
x_LI <- quantile(x)[2] - 1.5*(quantile(x)[4] - quantile(x)[2])
x_LI <- as.numeric(x_LI)
x_LI

#Limite Superior: -6.25

#limites inferior
x_LS <- quantile(x)[4] + 1.5*(quantile(x)[4] - quantile(x)[2])
x_LS <- as.numeric(x_LS)
x_LS

#Limite Inferior: -6.25

#d)
#boxplot
par(mar = c(5,5,2,2))
boxplot(x)

#e)
#Coeficiente de Pearson
library(moments)
x_as <- skewness(x)
x_as

# Coeficiente de Pearson: -0.216715
# Assimetrico

#f)
x_ord <- unique(sort(x))
x_ord

#Frequência Absoluta
fa_1 <- length(x[x==-5.0])
fa_2 <- length(x[x==-3.8])
fa_3 <- length(x[x==-2.8])
fa_4 <- length(x[x==-2.4])
fa_5 <- length(x[x==-2.0])
fa_6 <- length(x[x==-1.2])
fa_7 <- length(x[x==-0.9])
fa_8 <- length(x[x==-0.4])
fa_9 <- length(x[x==-0.2])
fa_10 <- length(x[x==0.5])
fa_11 <- length(x[x==1.3])
fa_12 <- length(x[x==1.4])
fa_13 <- length(x[x==1.6])
fa_14 <- length(x[x==2.8])
fa_15 <- length(x[x==2.9])
fa_16 <- length(x[x==3.0])
fa_17 <- length(x[x==3.3])
fa_18 <- length(x[x==3.5])
fa_19 <- length(x[x==4.0])
fa_20 <- length(x[x==4.1])
fa_21 <- length(x[x==4.4])
fa_22 <- length(x[x==4.5])
fa_23 <- length(x[x==4.9])
fa_24 <- length(x[x==5.1])
fa_25 <- length(x[x==5.3])
fa_26 <- length(x[x==5.4])
fa_27 <- length(x[x==5.6])
fa_28 <- length(x[x==5.8])
fa_29 <- length(x[x==6.0])
fa_30 <- length(x[x==6.3])
fa_31 <- length(x[x==6.5])
fa_32 <- length(x[x==6.6])
fa_33 <- length(x[x==6.7])
fa_34 <- length(x[x==7.0])
fa_35 <- length(x[x==7.2])
fa_36 <- length(x[x==8.9])
fa_37 <- length(x[x==9.7])
fa_38 <- length(x[x==10.0])
fa_39 <- length(x[x==10.6])
fa_40 <- length(x[x==10.7])
fa_41 <- length(x[x==11.1])
fa_42 <- length(x[x==11.4])

fa <- c(fa_1,fa_2,fa_3,fa_4,fa_5,fa_6,fa_7,fa_8,fa_9,fa_10,fa_11,fa_12,fa_13,fa_14,
        fa_15,fa_16,fa_17,fa_18,fa_19,fa_20,fa_21,fa_22,fa_23,fa_24,fa_25,fa_26,fa_27,
        fa_28,fa_29,fa_30,fa_31,fa_32,fa_33,fa_34,fa_35,fa_36,fa_37,fa_38,fa_39,fa_40,fa_41,fa_42)

fa

#Frequência Acumulada
Fa_1 = fa_1
Fa_2 = Fa_1 + fa_2
Fa_3 = Fa_2 + fa_3
Fa_4 = Fa_3 + fa_4
Fa_5 = Fa_4 + fa_5
Fa_6 = Fa_5 + fa_6
Fa_7 = Fa_6 + fa_7
Fa_8 = Fa_7 + fa_8
Fa_9 = Fa_8 + fa_9
Fa_10 = Fa_9 + fa_10
Fa_11 = Fa_10 + fa_11
Fa_12 = Fa_11 + fa_12
Fa_13 = Fa_12 + fa_13
Fa_14 = Fa_13 + fa_14
Fa_15 = Fa_14 + fa_15
Fa_16 = Fa_15 + fa_16
Fa_17 = Fa_16 + fa_17
Fa_18 = Fa_17 + fa_18
Fa_19 = Fa_18 + fa_19
Fa_20 = Fa_19 + fa_20
Fa_21 = Fa_20 + fa_21
Fa_22 = Fa_21 + fa_22
Fa_23 = Fa_22 + fa_23
Fa_24 = Fa_23 + fa_24
Fa_25 = Fa_24 + fa_25
Fa_26 = Fa_25 + fa_26
Fa_27 = Fa_26 + fa_27
Fa_28 = Fa_27 + fa_28
Fa_29 = Fa_28 + fa_29
Fa_30 = Fa_29 + fa_30
Fa_31 = Fa_30 + fa_31
Fa_32 = Fa_31 + fa_32
Fa_33 = Fa_32 + fa_33
Fa_34 = Fa_33 + fa_34
Fa_35 = Fa_34 + fa_35
Fa_36 = Fa_35 + fa_36
Fa_37 = Fa_36 + fa_37
Fa_38 = Fa_37 + fa_38
Fa_39 = Fa_38 + fa_39
Fa_40 = Fa_39 + fa_40
Fa_41 = Fa_40 + fa_41
Fa_42 = Fa_41 + fa_42

Fa <- c(Fa_1,Fa_2,Fa_3,Fa_4,Fa_5,Fa_6,Fa_7,Fa_8,Fa_9,Fa_10,Fa_11,Fa_12,Fa_13,Fa_14,
        Fa_15,Fa_16,Fa_17,Fa_18,Fa_19,Fa_20,Fa_21,Fa_22,Fa_23,Fa_24,Fa_25,Fa_26,Fa_27,
        Fa_28,Fa_29,Fa_30,Fa_31,Fa_32,Fa_33,Fa_34,Fa_35,Fa_36,Fa_37,Fa_38,Fa_39,Fa_40,Fa_41,Fa_42)

Fa

#Frequencia Relativa
fr_1 <- fa_1/(length(x))
fr_2 <- fa_2/(length(x))
fr_3 <- fa_3/(length(x))
fr_4 <- fa_4/(length(x))
fr_5 <- fa_5/(length(x))
fr_6 <- fa_6/(length(x))
fr_7 <- fa_7/(length(x))
fr_8 <- fa_8/(length(x))
fr_9 <- fa_9/(length(x))
fr_10 <- fa_10/(length(x))
fr_11 <- fa_11/(length(x))
fr_12 <- fa_12/(length(x))
fr_13 <- fa_13/(length(x))
fr_14 <- fa_14/(length(x))
fr_15 <- fa_15/(length(x))
fr_16 <- fa_16/(length(x))
fr_17 <- fa_17/(length(x))
fr_18 <- fa_18/(length(x))
fr_19 <- fa_19/(length(x))
fr_20 <- fa_20/(length(x))
fr_21 <- fa_21/(length(x))
fr_22 <- fa_22/(length(x))
fr_23 <- fa_23/(length(x))
fr_24 <- fa_24/(length(x))
fr_25 <- fa_25/(length(x))
fr_26 <- fa_26/(length(x))
fr_27 <- fa_27/(length(x))
fr_28 <- fa_28/(length(x))
fr_29 <- fa_29/(length(x))
fr_30 <- fa_30/(length(x))
fr_31 <- fa_31/(length(x))
fr_32 <- fa_32/(length(x))
fr_33 <- fa_33/(length(x))
fr_34 <- fa_34/(length(x))
fr_35 <- fa_35/(length(x))
fr_36 <- fa_36/(length(x))
fr_37 <- fa_37/(length(x))
fr_38 <- fa_38/(length(x))
fr_39 <- fa_39/(length(x))
fr_40 <- fa_40/(length(x))
fr_41 <- fa_41/(length(x))
fr_42 <- fa_42/(length(x))

fr <- c(fr_1,fr_2,fr_3,fr_4,fr_5,fr_6,fr_7,fr_8,fr_9,fr_10,fr_11,fr_12,fr_13,fr_14,
        fr_15,fr_16,fr_17,fr_18,fr_19,fr_20,fr_21,fr_22,fr_23,fr_24,fr_25,fr_26,fr_27,
        fr_28,fr_29,fr_30,fr_31,fr_32,fr_33,fr_34,fr_35,fr_36,fr_37,fr_38,fr_39,fr_40,fr_41,fr_42)

fr

#Frequência Relativa Acumulada
Fr_1 = fr_1
Fr_2 = Fr_1 + fr_2
Fr_3 = Fr_2 + fr_3
Fr_4 = Fr_3 + fr_4
Fr_5 = Fr_4 + fr_5
Fr_6 = Fr_5 + fr_6
Fr_7 = Fr_6 + fr_7
Fr_8 = Fr_7 + fr_8
Fr_9 = Fr_8 + fr_9
Fr_10 = Fr_9 + fr_10
Fr_11 = Fr_10 + fr_11
Fr_12 = Fr_11 + fr_12
Fr_13 = Fr_12 + fr_13
Fr_14 = Fr_13 + fr_14
Fr_15 = Fr_14 + fr_15
Fr_16 = Fr_15 + fr_16
Fr_17 = Fr_16 + fr_17
Fr_18 = Fr_17 + fr_18
Fr_19 = Fr_18 + fr_19
Fr_20 = Fr_19 + fr_20
Fr_21 = Fr_20 + fr_21
Fr_22 = Fr_21 + fr_22
Fr_23 = Fr_22 + fr_23
Fr_24 = Fr_23 + fr_24
Fr_25 = Fr_24 + fr_25
Fr_26 = Fr_25 + fr_26
Fr_27 = Fr_26 + fr_27
Fr_28 = Fr_27 + fr_28
Fr_29 = Fr_28 + fr_29
Fr_30 = Fr_29 + fr_30
Fr_31 = Fr_30 + fr_31
Fr_32 = Fr_31 + fr_32
Fr_33 = Fr_32 + fr_33
Fr_34 = Fr_33 + fr_34
Fr_35 = Fr_34 + fr_35
Fr_36 = Fr_35 + fr_36
Fr_37 = Fr_36 + fr_37
Fr_38 = Fr_37 + fr_38
Fr_39 = Fr_38 + fr_39
Fr_40 = Fr_39 + fr_40
Fr_41 = Fr_40 + fr_41
Fr_42 = Fr_41 + fr_42

Fr <- c(Fr_1,Fr_2,Fr_3,Fr_4,Fr_5,Fr_6,Fr_7,Fr_8,Fr_9,Fr_10,Fr_11,Fr_12,Fr_13,Fr_14,
        Fr_15,Fr_16,Fr_17,Fr_18,Fr_19,Fr_20,Fr_21,Fr_22,Fr_23,Fr_24,Fr_25,Fr_26,Fr_27,
        Fr_28,Fr_29,Fr_30,Fr_31,Fr_32,Fr_33,Fr_34,Fr_35,Fr_36,Fr_37,Fr_38,Fr_39,Fr_40,Fr_41,Fr_42)

Fr

#Frequencia Percentual
fp_1 <- fa_1/(length(x))*100
fp_2 <- fa_2/(length(x))*100
fp_3 <- fa_3/(length(x))*100
fp_4 <- fa_4/(length(x))*100
fp_5 <- fa_5/(length(x))*100
fp_6 <- fa_6/(length(x))*100
fp_7 <- fa_7/(length(x))*100
fp_8 <- fa_8/(length(x))*100
fp_9 <- fa_9/(length(x))*100
fp_10 <- fa_10/(length(x))*100
fp_11 <- fa_11/(length(x))*100
fp_12 <- fa_12/(length(x))*100
fp_13 <- fa_13/(length(x))*100
fp_14 <- fa_14/(length(x))*100
fp_15 <- fa_15/(length(x))*100
fp_16 <- fa_16/(length(x))*100
fp_17 <- fa_17/(length(x))*100
fp_18 <- fa_18/(length(x))*100
fp_19 <- fa_19/(length(x))*100
fp_20 <- fa_20/(length(x))*100
fp_21 <- fa_21/(length(x))*100
fp_22 <- fa_22/(length(x))*100
fp_23 <- fa_23/(length(x))*100
fp_24 <- fa_24/(length(x))*100
fp_25 <- fa_25/(length(x))*100
fp_26 <- fa_26/(length(x))*100
fp_27 <- fa_27/(length(x))*100
fp_28 <- fa_28/(length(x))*100
fp_29 <- fa_29/(length(x))*100
fp_30 <- fa_30/(length(x))*100
fp_31 <- fa_31/(length(x))*100
fp_32 <- fa_32/(length(x))*100
fp_33 <- fa_33/(length(x))*100
fp_34 <- fa_34/(length(x))*100
fp_35 <- fa_35/(length(x))*100
fp_36 <- fa_36/(length(x))*100
fp_37 <- fa_37/(length(x))*100
fp_38 <- fa_38/(length(x))*100
fp_39 <- fa_39/(length(x))*100
fp_40 <- fa_40/(length(x))*100
fp_41 <- fa_41/(length(x))*100
fp_42 <- fa_42/(length(x))*100

fp <- c(fp_1,fp_2,fp_3,fp_4,fp_5,fp_6,fp_7,fp_8,fp_9,fp_10,fp_11,fp_12,fp_13,fp_14,
        fp_15,fp_16,fp_17,fp_18,fp_19,fp_20,fp_21,fp_22,fp_23,fp_24,fp_25,fp_26,fp_27,
        fp_28,fp_29,fp_30,fp_31,fp_32,fp_33,fp_34,fp_35,fp_36,fp_37,fp_38,fp_39,fp_40,fp_41,fp_42)

fp

#Frequência Percentual Acumulada
Fp_1 = fp_1
Fp_2 = Fp_1 + fp_2
Fp_3 = Fp_2 + fp_3
Fp_4 = Fp_3 + fp_4
Fp_5 = Fp_4 + fp_5
Fp_6 = Fp_5 + fp_6
Fp_7 = Fp_6 + fp_7
Fp_8 = Fp_7 + fp_8
Fp_9 = Fp_8 + fp_9
Fp_10 = Fp_9 + fp_10
Fp_11 = Fp_10 + fp_11
Fp_12 = Fp_11 + fp_12
Fp_13 = Fp_12 + fp_13
Fp_14 = Fp_13 + fp_14
Fp_15 = Fp_14 + fp_15
Fp_16 = Fp_15 + fp_16
Fp_17 = Fp_16 + fp_17
Fp_18 = Fp_17 + fp_18
Fp_19 = Fp_18 + fp_19
Fp_20 = Fp_19 + fp_20
Fp_21 = Fp_20 + fp_21
Fp_22 = Fp_21 + fp_22
Fp_23 = Fp_22 + fp_23
Fp_24 = Fp_23 + fp_24
Fp_25 = Fp_24 + fp_25
Fp_26 = Fp_25 + fp_26
Fp_27 = Fp_26 + fp_27
Fp_28 = Fp_27 + fp_28
Fp_29 = Fp_28 + fp_29
Fp_30 = Fp_29 + fp_30
Fp_31 = Fp_30 + fp_31
Fp_32 = Fp_31 + fp_32
Fp_33 = Fp_32 + fp_33
Fp_34 = Fp_33 + fp_34
Fp_35 = Fp_34 + fp_35
Fp_36 = Fp_35 + fp_36
Fp_37 = Fp_36 + fp_37
Fp_38 = Fp_37 + fp_38
Fp_39 = Fp_38 + fp_39
Fp_40 = Fp_39 + fp_40
Fp_41 = Fp_40 + fp_41
Fp_42 = Fp_41 + fp_42

Fp <- c(Fp_1,Fp_2,Fp_3,Fp_4,Fp_5,Fp_6,Fp_7,Fp_8,Fp_9,Fp_10,Fp_11,Fp_12,Fp_13,Fp_14,
        Fp_15,Fp_16,Fp_17,Fp_18,Fp_19,Fp_20,Fp_21,Fp_22,Fp_23,Fp_24,Fp_25,Fp_26,Fp_27,
        Fp_28,Fp_29,Fp_30,Fp_31,Fp_32,Fp_33,Fp_34,Fp_35,Fp_36,Fp_37,Fp_38,Fp_39,Fp_40,Fp_41,Fp_42)

Fp

#f)
#tabela com os valores
col_1 <- c(fa)
col_2 <- c(Fa)
col_3 <- c(fr)
col_4 <- c(Fr)
col_5 <- c(fp)
col_6 <- c(Fp)

tabela <- data.frame(col_1, col_2, col_3, col_4, col_5, col_6)
colnames(tabela) <- c("fa", "Fa", "fr", "Fr", "fp", "Fp")
tabela

#g)
# Histograma com polígono de frequência
valor <- unique(sort(x))
freq <- cbind(valor, fa)
hist(x, breaks = 45, main="Histograma", axes=F, xlab="", ylab="")
axis(side=1, at=seq(-6, 15, by=3))
axis(side=2, at=seq(0, 7, by=1))
lines(freq, type="b")

#2)

options(digits=6)

Ne1 <- 12
Ne2 <- 22
Ne3 <- 7
Ne4 <- 29
N <- Ne1 + Ne2 + Ne3 + Ne4
n <- 25
W1 <- Ne1/N
W2 <- Ne2/N
W3 <- Ne3/N
W4 <- Ne4/N


amostra4estratos <- function(n,Ne1,Ne2,Ne3,Ne4){
    n1 <- W1 * n; n2 <- W2 * n; n3 <- W3 * n; n4 <- W4 * n

    col_1 <- c(n1)
    col_2 <- c(n2)
    col_3 <- c(n3)
    col_4 <- c(n4)
    tabela <- data.frame(col_1, col_2, col_3, col_4)
    colnames(tabela) <- c("Grupo 1", "Grupo 2", "Grupo 3", "Grupo 4")
    tabela
    round(tabela)
}

amostra4estratos(25, 12, 22, 7, 29)

