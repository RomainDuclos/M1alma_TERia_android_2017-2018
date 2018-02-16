

```python
from interval import interval, inf, imath
a = interval[5.0,5.1]
b = interval[1.0,2.0]
c = interval[0.36,0.899]
d = interval[-1.0,1.0]
print("a = " , a)
print("b = " , b)
print("c = " , c)
print("d = " , d)

print("a+b = ", a + b)
print("c inter d = ", c & d)
print("a*c = ", a * c)
print("sin(a) = " ,imath.sin(a))
print("cos(b) = " , imath.cos(b))
print("midpoint(d) =" , d.midpoint)
```

    a =  interval([5.0, 5.1])
    b =  interval([1.0, 2.0])
    c =  interval([0.36, 0.899])
    d =  interval([-1.0, 1.0])
    a+b =  interval([6.0, 7.1])
    c inter d =  interval([0.36, 0.899])
    a*c =  interval([1.7999999999999998, 4.5849])
    sin(a) =  interval([-0.9589242746631386, -0.9258146823277323])
    cos(b) =  interval([-0.4161468365471424, 0.5403023058681398])
    midpoint(d) = interval([0.0])

