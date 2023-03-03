#1. E(X) = 1/(b+a); Var(x) = ((b-a)^2)/12

#2. a = 3 e b = 5

#3.
f <- function(x) {1/2}
integrate(Vectorize(f), lower = 3, upper = 5)

#4.
e_x <- 1/(3+5)
e_x

var_x <- ((5-3)^2)/12
var_x

f <- function(x) {25*exp(1)^(-25*x)}
integrate(f, lower = 0.1, upper = Inf)

med <- 100
sigma <- 5
f <- function(x) 1/(sigma*sqrt(2*pi))*exp(1)^(-1/2*((x - med)/sigma)^2)

integrate(f, lower = 1, upper = 2)

integrate(f, lower = 100, upper = 106)
