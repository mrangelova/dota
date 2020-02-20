package processors.core;

import org.kohsuke.args4j.Option;

public class DotaAppArgs {
    @Option(name="-ip",usage="kafka server ip address + port number")
    public String ip="";
    @Option(name="-topic",usage="kafka topic")
    public String topic="";
    @Option(name="-key",usage="steam api key")
    public String key="";
    @Option(name="-id",usage="match id to start from")
    public String id="";
    @Option(name="-rn",usage="number of requests")
    public String rn="";

}
