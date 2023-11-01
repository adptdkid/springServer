insert into race (race_name) values
                                 ('Ааракора'),
                                 ('Полурослик'),
                                 ('Эльф'),
                                 ('Гном'),
                                 ('Гнолл'),
                                 ('Сатир'),
                                 ('Человек'),
                                 ('Кобольд') ON CONFLICT DO NOTHING;

insert into character_class (character_class_name) values
                                 ('Бард'),
                                 ('Варвар'),
                                 ('Воин'),
                                 ('Волшебник'),
                                 ('Друид'),
                                 ('Жрец'),
                                 ('Колдун'),
                                 ('Монах') ON CONFLICT DO NOTHING;