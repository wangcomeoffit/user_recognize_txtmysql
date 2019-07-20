package user_recognize_txt;

import java.util.List;

public class Words {
        private int id;
        private String text;
        private int score;
        private int post;
        private int conf;
        private int word_start;
        private int word_end;
        private int duration;
        private int state;
        private List<Phon> phon;
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }

        public void setText(String text) {
            this.text = text;
        }
        public String getText() {
            return text;
        }

        public void setScore(int score) {
            this.score = score;
        }
        public int getScore() {
            return score;
        }

        public void setPost(int post) {
            this.post = post;
        }
        public int getPost() {
            return post;
        }

        public void setConf(int conf) {
            this.conf = conf;
        }
        public int getConf() {
            return conf;
        }

        public void setWord_start(int word_start) {
            this.word_start = word_start;
        }
        public int getWord_start() {
            return word_start;
        }

        public void setWord_end(int word_end) {
            this.word_end = word_end;
        }
        public int getWord_end() {
            return word_end;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }
        public int getDuration() {
            return duration;
        }

        public void setState(int state) {
            this.state = state;
        }
        public int getState() {
            return state;
        }

        public void setPhon(List<Phon> phon) {
            this.phon = phon;
        }
        public List<Phon> getPhon() {
            return phon;
        }
}
