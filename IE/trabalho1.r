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