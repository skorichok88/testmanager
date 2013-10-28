CREATE TABLE `testmanager`.`question_answers` (
  `question_id` INT NOT NULL,
  `answer_id` INT NOT NULL,
  INDEX `question_answers_fk1_idx` (`question_id` ASC),
  INDEX `question_answers_fk2_idx` (`answer_id` ASC),
  CONSTRAINT `question_answers_fk1`
    FOREIGN KEY (`question_id`)
    REFERENCES `testmanager`.`questions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `question_answers_fk2`
    FOREIGN KEY (`answer_id`)
    REFERENCES `testmanager`.`answers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;