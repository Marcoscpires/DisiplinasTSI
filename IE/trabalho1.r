#01 
#média:
x <- c(10, 94, 32, 19, 55, 35, 20, 48, 68, 24, 18, 83, 30, 62, 85, 50, 20, 90, 60, 14, 92, 20, 15, 58, 75, 16, 48, 81, 79, 46)

x_sum <- sum(x)
x_len <- length(x)
c(x_sum, x_len)

x_med <- x_sum/x_len
x_med

#mediana
x_mediana <- median(x)
x_mediana

#moda
x_tab <- as.matrix(table(x))
x_mod <- subset(x_tab, x_tab[ , 1] == max(x_tab[ , 1]))
x_mod

#02
#variança
x_var <- var(x)
x_var

#desvio padrão:
x_sd <- sd(x)
x_sd

#coeficiente de variação:
x_cv <- sd(x)/mean(x)*100
x_cv

#03
#quartis
x_qua <- quantile(x)
x_qua

#limites superior
x_LI <- quantile(x)[2] - 1.5*(quantile(x)[4] - quantile(x)[2])
x_LI <- as.numeric(x_LI)
x_LI

#limites inferior
x_LS <- quantile(x)[4] + 1.5*(quantile(x)[4] - quantile(x)[2])
x_LS <- as.numeric(x_LS)
x_LS

#04
#boxplot
par(mar = c(5,5,2,2))
boxplot(x)

#05
#Coeficiente de Pearson
library(moments)
x_as <- skewness(x)
x_as

x_ord <- sort(x)
x_ord

#Frequência Absoluta
fa_1 <- length(x[x==10])
fa_2 <- length(x[x==14])
fa_3 <- length(x[x==15])
fa_4 <- length(x[x==16])
fa_5 <- length(x[x==18])
fa_6 <- length(x[x==19])
fa_7 <- length(x[x==20])
fa_8 <- length(x[x==24])
fa_9 <- length(x[x==30])
fa_10 <- length(x[x==32])
fa_11 <- length(x[x==35])
fa_12 <- length(x[x==46])
fa_13 <- length(x[x==48])
fa_14 <- length(x[x==50])
fa_15 <- length(x[x==55])
fa_16 <- length(x[x==58])
fa_17 <- length(x[x==60])
fa_18 <- length(x[x==62])
fa_19 <- length(x[x==68])
fa_20 <- length(x[x==75])
fa_21 <- length(x[x==79])
fa_22 <- length(x[x==81])
fa_23 <- length(x[x==83])
fa_24 <- length(x[x==85])
fa_25 <- length(x[x==90])
fa_26 <- length(x[x==92])
fa_27 <- length(x[x==94])

fa <- c(fa_1,fa_2,fa_3,fa_4,fa_5,fa_6,fa_7,fa_8,fa_9,fa_10,fa_11,fa_12,fa_13,fa_14,
fa_15,fa_16,fa_17,fa_18,fa_19,fa_20,fa_21,fa_22,fa_23,fa_24,fa_25,fa_26,fa_27)

#Frequência Acumulada
Fa_1 <- fa_1
Fa_2 <- fa_1 + fa_2
Fa_3 <- fa_1 + fa_2 + fa_3
Fa_4 <- fa_1 + fa_2 + fa_3 + fa_4
Fa_5 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5
Fa_6 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6
Fa_7 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 
Fa_8 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8
Fa_9 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9
Fa_10 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10
Fa_11 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11
Fa_12 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12
Fa_13 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 
Fa_14 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14
Fa_15 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15
Fa_16 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16
Fa_17 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17
Fa_18 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18
Fa_19 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18 + fa_19
Fa_20 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18 + fa_19 + fa_20
Fa_21 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18 + fa_19 + fa_20 + fa_21
Fa_22 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18 + fa_19 + fa_20 + fa_21 + fa_22
Fa_23 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18 + fa_19 + fa_20 + fa_21 + fa_22 + fa_23
Fa_24 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18 + fa_19 + fa_20 + fa_21 + fa_22 + fa_23 + fa_24
Fa_25 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18 + fa_19 + fa_20 + fa_21 + fa_22 + fa_23 + fa_24 + fa_25
Fa_26 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18 + fa_19 + fa_20 + fa_21 + fa_22 + fa_23 + fa_24 + fa_25 + fa_26
Fa_27 <- fa_1 + fa_2 + fa_3 + fa_4 + fa_5 + fa_6 + fa_7 + fa_8 + fa_9 + fa_10 + fa_11 + fa_12 + fa_13 + fa_14 + fa_15 + fa_16 + fa_17 + fa_18 + fa_19 + fa_20 + fa_21 + fa_22 + fa_23 + fa_24 + fa_25 + fa_26 + fa_27

Fa <- c(Fa_1,Fa_2,Fa_3,Fa_4,Fa_5,Fa_6,Fa_7,Fa_8,Fa_9,Fa_10,Fa_11,Fa_12,Fa_13,Fa_14,Fa_15,Fa_16
	,Fa_17,Fa_18,Fa_19,Fa_20,Fa_21,Fa_22,Fa_23,Fa_24,Fa_25,Fa_26,Fa_27)

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

fr <- c(fr_1,fr_2,fr_3,fr_4,fr_5,fr_6,fr_7,fr_8,fr_9,fr_10,fr_11,fr_12,fr_13,fr_14,
fr_15,fr_16,fr_17,fr_18,fr_19,fr_20,fr_21,fr_22,fr_23,fr_24,fr_25,fr_26,fr_27)

#Frequência Relativa Acumulada
Fr_1 <- Fa_1/(length(x))
Fr_2 <- Fa_2/(length(x))
Fr_3 <- Fa_3/(length(x))
Fr_4 <- Fa_4/(length(x))
Fr_5 <- Fa_5/(length(x))
Fr_6 <- Fa_6/(length(x))
Fr_7 <- Fa_7/(length(x))
Fr_8 <- Fa_8/(length(x))
Fr_9 <- Fa_9/(length(x))
Fr_10 <- Fa_10/(length(x))
Fr_11 <- Fa_11/(length(x))
Fr_12 <- Fa_12/(length(x))
Fr_13 <- Fa_13/(length(x))
Fr_14 <- Fa_14/(length(x))
Fr_15 <- Fa_15/(length(x))
Fr_16 <- Fa_16/(length(x))
Fr_17 <- Fa_17/(length(x))
Fr_18 <- Fa_18/(length(x))
Fr_19 <- Fa_19/(length(x))
Fr_20 <- Fa_20/(length(x))
Fr_21 <- Fa_21/(length(x))
Fr_22 <- Fa_22/(length(x))
Fr_23 <- Fa_23/(length(x))
Fr_24 <- Fa_24/(length(x))
Fr_25 <- Fa_25/(length(x))
Fr_26 <- Fa_26/(length(x))
Fr_27 <- Fa_27/(length(x))

Fr <- c(Fr_1,Fr_2,Fr_3,Fr_4,Fr_5,Fr_6,Fr_7,Fr_8,Fr_9,Fr_10,Fr_11,Fr_12,Fr_13,Fr_14,Fr_15,Fr_16 # nolint
	,Fr_17,Fr_18,Fr_19,Fr_20,Fr_21,Fr_22,Fr_23,Fr_24,Fr_25,Fr_26,Fr_27)

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

fp <- c(fp_1,fp_2,fp_3,fp_4,fp_5,fp_6,fp_7,fp_8,fp_9,fp_10,fp_11,fp_12,fp_13,fp_14,
fp_15,fp_16,fp_17,fp_18,fp_19,fp_20,fp_21,fp_22,fp_23,fp_24,fp_25,fp_26,fp_27)

#Frequência Percentual Acumulada
Fp_1 <- fp_1
Fp_2 <- fp_1 + fp_2
Fp_3 <- fp_1 + fp_2 + fp_3
Fp_4 <- fp_1 + fp_2 + fp_3 + fp_4
Fp_5 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5
Fp_6 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6
Fp_7 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7
Fp_8 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 +  fp_8
Fp_9 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 +  fp_8 + fp_9
Fp_10 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10
Fp_11 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11
Fp_12 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12
Fp_13 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13
Fp_14 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14
Fp_15 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15
Fp_16 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16
Fp_17 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17
Fp_18 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18
Fp_19 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18 + fp_19
Fp_20 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18 + fp_19 + fp_20
Fp_21 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18 + fp_19 + fp_20 + fp_21
Fp_22 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18 + fp_19 + fp_20 + fp_21 + fp_22
Fp_23 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18 + fp_19 + fp_20 + fp_21 + fp_22 + fp_23
Fp_24 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18 + fp_19 + fp_20 + fp_21 + fp_22 + fp_23 + fp_24
Fp_25 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18 + fp_19 + fp_20 + fp_21 + fp_22 + fp_23 + fp_24 + fp_25
Fp_26 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18 + fp_19 + fp_20 + fp_21 + fp_22 + fp_23 + fp_24 + fp_25 + fp_26
Fp_27 <- fp_1 + fp_2 + fp_3 + fp_4 + fp_5 + fp_6 + fp_7 + fp_8 + fp_9 + fp_10 + fp_11 + fp_12 + fp_13 + fp_14 + fp_15 + fp_16 + fp_17 + fp_18 + fp_19 + fp_20 + fp_21 + fp_22 + fp_23 + fp_24 + fp_25 + fp_26 + fp_27

Fp <- c(Fp_1,Fp_2,Fp_3,Fp_4,Fp_5,Fp_6,Fp_7,Fp_8,Fp_9,Fp_10,Fp_11,Fp_12,Fp_13,Fp_14,Fp_15,Fp_16
	,Fp_17,Fp_18,Fp_19,Fp_20,Fp_21,Fp_22,Fp_23,Fp_24,Fp_25,Fp_26,Fp_27)

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

#07
valor <- unique(sort(x))
freq <- cbind(valor, fa)
hist(x, breaks = 30, main="Histograma", axes=F, xlab="", ylab="")
axis(side=1, at=seq(1, 94, by=2))
axis(side=2, at=seq(0, 7, by=1))
lines(freq, type="b")


