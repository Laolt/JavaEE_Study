package org.example.bean;

public class testjob {
    int jid;
    String jobName;

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "testjob{" +
                "jid=" + jid +
                ", jobName='" + jobName + '\'' +
                '}';
    }
}
