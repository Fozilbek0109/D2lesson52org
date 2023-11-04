package com.example.d2lesson52.service;


import com.example.d2lesson52.models.QuestionModel;

import java.util.ArrayList;
import java.util.List;





public class QuestionModelImpl implements QuestionModelService{
    private List<QuestionModel> list;
    @Override
    public void add() {
        list = new ArrayList<>();
        list.add(new QuestionModel("Qadimdan bizgacha yetib kelgan lotin aforizmiga koʻra – \"Siz haqiqatni soʻzlasangiz, \"X\"ning keragi yoʻq!\" Aforizmda keltirilgan \"X\" kim? ", "Qarindosh", "Dost", "Guvoh", "Tog'ri javob yo'q", "Guvoh"));
        list.add(new QuestionModel("Bodriral xalqida shunday gap bor: «U – qamoqxonalarni mahbuslar bilan to‘ldirib turuvchi xizmatkordir!». Ushbu fikrda keltirilgan \"U\" nima?", "mast qiluvchi ichimiklar", "qurol", "Shlyapa", "Barcha Javoblar", "mast qiluvchi ichimiklar"));
        list.add(new QuestionModel("Qanday keng tarqalgan qishloq xo'jaligi hayvonlarining yuqori jag'ida tishlari yo'q?", "Sigir", "Buqa", "Qo'y va echki", "quyon", "Qo'y va echki"));
        list.add(new QuestionModel("Erkak pingvin ko'pincha uni yutib olish uchun ayol penguenga qaysi narsani sovg'a qiladi?", "Muz", "Qoya", "O'z patidan", "Baliq", "Qoya"));
        list.add(new QuestionModel("Okeanda qaysi baliq eng tezkor ekanligi ma'lum?", "Yelkan baliqlari", "Ilon baliq", "Laqa baliq", "Chortan baliq", "Yelkan baliqlari"));
    }

    @Override
    public List<QuestionModel> getList() {
        return list;
    }

}
