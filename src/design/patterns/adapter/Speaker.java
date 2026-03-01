package design.patterns.adapter;

public interface Speaker {
    String sayHello();
}

class EnglishSpeaker implements Speaker {

    @Override
    public String sayHello() {
        return "Hello, I am here!";
    }
}

class GermanSpeaker implements Speaker {

    @Override
    public String sayHello() {
        return "Halo, em ther";
    }
}

class GermanToEnglishSpeaker implements Speaker {

    private final EnglishSpeaker englishSpeaker;

    public GermanToEnglishSpeaker(EnglishSpeaker englishSpeaker) {
        this.englishSpeaker = englishSpeaker;
    }

    @Override
    public String sayHello() {
        return englishSpeaker.sayHello();
    }
}