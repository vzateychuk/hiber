CREATE TABLE `CHART` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `SUBJECT_AREA` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `CHART_TO_SUBJ_AREA_REF` (
  `chart_id` int(11) unsigned NOT NULL,
  `subj_area_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`chart_id`,`subj_area_id`),
  CONSTRAINT `ref_chart` FOREIGN KEY (`chart_id`) REFERENCES `CHART` (`id`),
  CONSTRAINT `ref_subject_area` FOREIGN KEY (`subj_area_id`) REFERENCES `SUBJECT_AREA` (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;