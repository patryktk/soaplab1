package pl.tkaczyk.soaplab1;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import pl.tkaczyk.soaplab1wsdl.RegisterCallRequest;
import pl.tkaczyk.soaplab1wsdl.RegisterCallResponse;
import pl.tkaczyk.soaplab1wsdl.ResultsRequest;
import pl.tkaczyk.soaplab1wsdl.ResultsResponse;


public class WebClient extends WebServiceGatewaySupport {

    public ResultsResponse getResult(String value){
        ResultsRequest resultsRequest = new ResultsRequest();
        resultsRequest.setStudent(value);
        return  (ResultsResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8088/mockApiPortSoap11", resultsRequest);
    }

    public RegisterCallResponse registerCallResponse(String student){
        RegisterCallRequest registerCallRequest = new RegisterCallRequest();
        registerCallRequest.setStudent(student);
        return (RegisterCallResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:8088/mockApiPortSoap11", registerCallRequest);
    }
}
