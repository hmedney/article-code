package hmedney.flink;

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleJob {
  public static final Logger LOG = LoggerFactory.getLogger(ExampleJob.class);

  public static void main(String[] args) throws Exception {
    LOG.info("================= Begin building job graph =================");
    StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
    env.execute("flink-debugging-example");
    LOG.info("================= End building job graph =================");
  }
}