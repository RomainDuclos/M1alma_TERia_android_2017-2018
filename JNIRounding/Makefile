all:
	javac Main.java RoundingJNI.java
	javah -jni RoundingJNI
	gcc -fPIC -I"/usr/lib/jvm/java-1.8.0-openjdk-amd64/include" -I"/usr/lib/jvm/java-1.8.0-openjdk-amd64/include/linux" -shared RoundingJNI.c -o libRoundingLib.so
	java -Djava.library.path=. Main



