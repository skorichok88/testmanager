CREATE TABLE `questions` (
  `id` int NOT NULL,
  `text` varchar(500) NOT NULL,
  `correct_answer_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `questions_answers_fk1_idx` (`correct_answer_id`),
  CONSTRAINT `questions_answers_fk1`
  FOREIGN KEY (`correct_answer_id`)
  REFERENCES `answers` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
