package com.example.projects.aiAgents;

public class Work {
    public static void main(String[] args) {
        IWorkType workType = new Code();
        IAgents agent = new Grok();

        Work w = new Work();
        w.doWork(agent, workType);
    }

    public void doWork(IAgents agent, IWorkType workType) {
        agent.doWork(workType);
    }
}
