ALTER TABLE task
  ADD COLUMN id_parent NUMBER (19);
ALTER TABLE task
  ADD CONSTRAINT fk_parent_task FOREIGN KEY (id_parent)
REFERENCES task (id_task);

