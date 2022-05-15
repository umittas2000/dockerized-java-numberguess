FROM openjdk:18
COPY ./NumberGuess/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","NumberGuess.java"]