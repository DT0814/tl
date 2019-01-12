package cn.xdlr.tl.bcosliteClient;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;
import org.bcos.channel.client.TransactionSucCallback;
import org.bcos.web3j.abi.EventEncoder;
import org.bcos.web3j.abi.EventValues;
import org.bcos.web3j.abi.TypeReference;
import org.bcos.web3j.abi.datatypes.Event;
import org.bcos.web3j.abi.datatypes.Function;
import org.bcos.web3j.abi.datatypes.Type;
import org.bcos.web3j.abi.datatypes.Utf8String;
import org.bcos.web3j.abi.datatypes.generated.Uint256;
import org.bcos.web3j.abi.datatypes.generated.Uint8;
import org.bcos.web3j.crypto.Credentials;
import org.bcos.web3j.protocol.Web3j;
import org.bcos.web3j.protocol.core.DefaultBlockParameter;
import org.bcos.web3j.protocol.core.methods.request.EthFilter;
import org.bcos.web3j.protocol.core.methods.response.Log;
import org.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.bcos.web3j.tx.Contract;
import org.bcos.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Auto generated code.<br>
 * <strong>Do not modify!</strong><br>
 * Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>, or {@link org.bcos.web3j.codegen.SolidityFunctionWrapperGenerator} to update.
 *
 * <p>Generated with web3j version none.
 */
public final class Integral extends Contract {
    private static String BINARY = "6060604052341561000c57fe5b5b611b308061001c6000396000f30060606040523615610097576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630cedba2b1461009957806323976a62146101105780636da60673146101f15780636f6f51f01461029857806391a77c0814610351578063954095cc146103a3578063d8d22a2d146103d7578063e90ef41b14610475578063ff74927b146104ec575bfe5b34156100a157fe5b6100fa600480803590602001909190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610610565b6040518082815260200191505060405180910390f35b341561011857fe5b610168600480803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610762565b60405180806020018281038252838181518152602001915080519060200190808383600083146101b7575b8051825260208311156101b757602082019150602081019050602083039250610193565b505050905090810190601f1680156101e35780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156101f957fe5b61020f60048080359060200190919050506108c2565b604051808060200182810382528381815181526020019150805190602001908083836000831461025e575b80518252602083111561025e5760208201915060208101905060208303925061023a565b505050905090810190601f16801561028a5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156102a057fe5b6102c86004808035906020019091908035906020019091908035906020019091905050610e84565b6040518080602001828103825283818151815260200191508051906020019080838360008314610317575b805182526020831115610317576020820191506020810190506020830392506102f3565b505050905090810190601f1680156103435780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561035957fe5b61038d600480803590602001909190803590602001909190803590602001909190803560ff169060200190919050506112c5565b6040518082815260200191505060405180910390f35b34156103ab57fe5b6103c160048080359060200190919050506113f4565b6040518082815260200191505060405180910390f35b34156103df57fe5b61045f600480803590602001909190803590602001909190803590602001909190803590602001909190803560ff1690602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061141b565b6040518082815260200191505060405180910390f35b341561047d57fe5b6104d6600480803590602001909190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050611500565b6040518082815260200191505060405180910390f35b34156104f457fe5b610587600480803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506115ac565b60405180806020018281038252838181518152602001915080519060200190808383600083146105d6575b8051825260208311156105d6576020820191506020810190506020830392506105b2565b505050905090810190601f1680156106025780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b60006080604051908101604052808481526020018381526020016000815260200160018152506000600085815260200190815260200160002060008201518160000155602082015181600101908051906020019061066f929190611a23565b5060408201518160020155606082015181600301559050507f6a9652e6600a11dc016f52ee1d74bb888dfa06559ab66c952521aa3870b65c2383836000600087815260200190815260200160002060020154604051808481526020018060200183815260200182810382528481815181526020019150805190602001908083836000831461071c575b80518252602083111561071c576020820191506020810190506020830392506106f8565b505050905090810190601f1680156107485780820380516001836020036101000a031916815260200191505b5094505050505060405180910390a1600090505b92915050565b61076a611aa3565b610772611ab7565b61077a611aa3565b610782611ab7565b60006000869450600185510360405180591061079b5750595b908082528060200260200182016040525b50935083925060009150600090505b60018551038110156108725784818151811015156107d557fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561083457fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b80806001019150506107bb565b6108b284604060405190810160405280600181526020017f5d000000000000000000000000000000000000000000000000000000000000008152506115ac565b93508395505b5050505050919050565b6108ca611aa3565b6108d2611acb565b60006108dc611aa3565b6108e4611ab7565b60007f3000000000000000000000000000000000000000000000000000000000000000600160006000815260200190815260200160002060006101000a81548160ff02191690837f0100000000000000000000000000000000000000000000000000000000000000900402179055507f3100000000000000000000000000000000000000000000000000000000000000600160006001815260200190815260200160002060006101000a81548160ff02191690837f0100000000000000000000000000000000000000000000000000000000000000900402179055507f3200000000000000000000000000000000000000000000000000000000000000600160006002815260200190815260200160002060006101000a81548160ff02191690837f0100000000000000000000000000000000000000000000000000000000000000900402179055507f3300000000000000000000000000000000000000000000000000000000000000600160006003815260200190815260200160002060006101000a81548160ff02191690837f0100000000000000000000000000000000000000000000000000000000000000900402179055507f3400000000000000000000000000000000000000000000000000000000000000600160006004815260200190815260200160002060006101000a81548160ff02191690837f0100000000000000000000000000000000000000000000000000000000000000900402179055507f3500000000000000000000000000000000000000000000000000000000000000600160006005815260200190815260200160002060006101000a81548160ff02191690837f0100000000000000000000000000000000000000000000000000000000000000900402179055507f3600000000000000000000000000000000000000000000000000000000000000600160006006815260200190815260200160002060006101000a81548160ff02191690837f0100000000000000000000000000000000000000000000000000000000000000900402179055507f3700000000000000000000000000000000000000000000000000000000000000600160006007815260200190815260200160002060006101000a81548160ff02191690837f0100000000000000000000000000000000000000000000000000000000000000900402179055507f3800000000000000000000000000000000000000000000000000000000000000600160006008815260200190815260200160002060006101000a81548160ff02191690837f0100000000000000000000000000000000000000000000000000000000000000900402179055507f3900000000000000000000000000000000000000000000000000000000000000600160006009815260200190815260200160002060006101000a81548160ff02191690837f010000000000000000000000000000000000000000000000000000000000000090040217905550600a604051805910610d375750595b908082528060200260200182016040525b509450600093505b6000871115610d9c57600a87811515610d6557fe5b068585806001019650815181101515610d7a57fe5b9060200190602002018181525050600a87811515610d9457fe5b049650610d50565b83604051805910610daa5750595b908082528060200260200182016040525b509250829150600090505b6000841115610e765760016000868660019003965086815181101515610de857fe5b90602001906020020151815260200190815260200160002060009054906101000a90047f0100000000000000000000000000000000000000000000000000000000000000028282806001019350815181101515610e4157fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a905350610dc6565b8295505b5050505050919050565b610e8c611aa3565b610e94611aa3565b610e9c611aa3565b610ea4611aa3565b610eac611aa3565b610eb4611aa3565b600060006000604060405190810160405280600781526020017f56616c75653a5b000000000000000000000000000000000000000000000000008152509750604060405190810160405280600681526020017f274964273a2700000000000000000000000000000000000000000000000000008152509650604060405190810160405280600981526020017f2756616c7565273a2700000000000000000000000000000000000000000000008152509550604060405190810160405280600a81526020017f27526561736f6e273a27000000000000000000000000000000000000000000008152509450604060405190810160405280600881526020017f2754696d65273a270000000000000000000000000000000000000000000000008152509350600192508b9150600060008381526020019081526020016000206003015490505b80831115801561103257508a6000600084815260200190815260200160002060040160008581526020019081526020016000206004015410155b80156110685750896000600084815260200190815260200160002060040160008581526020019081526020016000206004015411155b156112a757611106886111016110c56110b7604060405190810160405280600181526020017f7b000000000000000000000000000000000000000000000000000000000000008152508c6115ac565b6110c0876108c2565b6115ac565b604060405190810160405280600281526020017f272c0000000000000000000000000000000000000000000000000000000000008152506115ac565b6115ac565b975061118c8861118761114b896111466000600089815260200190815260200160002060040160008a8152602001908152602001600020600301546108c2565b6115ac565b604060405190810160405280600281526020017f272c0000000000000000000000000000000000000000000000000000000000008152506115ac565b6115ac565b97506112128861120d6111d1886111cc6000600089815260200190815260200160002060040160008a8152602001908152602001600020600401546108c2565b6115ac565b604060405190810160405280600281526020017f272c0000000000000000000000000000000000000000000000000000000000008152506115ac565b6115ac565b975061129888611293611257876112526000600089815260200190815260200160002060040160008a8152602001908152602001600020600401546108c2565b6115ac565b604060405190810160405280600381526020017f277d2c00000000000000000000000000000000000000000000000000000000008152506115ac565b6115ac565b97508280600101935050610ff8565b6112b088610762565b97508798505b50505050505050509392505050565b6000600060006112d4876113f4565b915060016000600089815260200190815260200160002060030154019050600060018111156112ff57fe5b84600181111561130b57fe5b141561135e57611358816000898989878a604060405190810160405280600481526020017f496e666f0000000000000000000000000000000000000000000000000000000081525061178d565b506113e5565b6001600181111561136b57fe5b84600181111561137757fe5b14156113db578582101561138e57600192506113ea565b6113d5818860008989878a604060405190810160405280600481526020017f496e666f000000000000000000000000000000000000000000000000000000008152506118d8565b506113e4565b600192506113ea565b5b600092505b5050949350505050565b60006000600060008481526020019081526020016000206002015490508091505b50919050565b6000600060006000600061142e8b6113f4565b93506114398a6113f4565b92506001600060008d8152602001908152602001600020600301540191506001600060008c8152602001908152602001600020600301540190508884101561148457600194506114f2565b611494828c8c8c8c898d8d61178d565b507f214a275c789a70c7b843e5a160c2f70763afbc66a41902a95cc975e6058cfd598b8b8b60405180848152602001838152602001828152602001935050505060405180910390a16114ec818c8c8c8c888d8d6118d8565b50600094505b505050509695505050505050565b600060806040519081016040528084815260200183815260200160006000868152602001908152602001600020600201548152602001600060008681526020019081526020016000206003015481525060006000858152602001908152602001600020600082015181600001556020820151816001019080519060200190611589929190611a23565b506040820151816002015560608201518160030155905050600190505b92915050565b6115b4611aa3565b6115bc611ab7565b6115c4611ab7565b6115cc611aa3565b6115d4611ab7565b6000600088955087945084518651016040518059106115f05750595b908082528060200260200182016040525b50935083925060009150600090505b85518110156116c457858181518110151561162757fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561168657fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b8080600101915050611610565b600090505b845181101561177d5784818151811015156116e057fe5b9060200101517f010000000000000000000000000000000000000000000000000000000000000090047f010000000000000000000000000000000000000000000000000000000000000002838380600101945081518110151561173f57fe5b9060200101907effffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff1916908160001a9053505b80806001019150506116c9565b8396505b50505050505092915050565b60006000899050610100604051908101604052808281526020018a81526020018981526020018881526020018781526020018560018111156117cb57fe5b8152602001848152602001888701815250600060008a81526020019081526020016000206004016000838152602001908152602001600020600082015181600001556020820151816001015560408201518160020155606082015181600301556080820151816004015560a08201518160050160006101000a81548160ff0219169083600181111561185957fe5b021790555060c082015181600601908051906020019061187a929190611a23565b5060e0820151816007015590505086600060008a81526020019081526020016000206002016000828254019250508190555080600060008a8152602001908152602001600020600301819055508091505b5098975050505050505050565b60006000899050610100604051908101604052808281526020018a815260200189815260200188815260200187815260200185600181111561191657fe5b8152602001848152602001888701815250600060008b81526020019081526020016000206004016000838152602001908152602001600020600082015181600001556020820151816001015560408201518160020155606082015181600301556080820151816004015560a08201518160050160006101000a81548160ff021916908360018111156119a457fe5b021790555060c08201518160060190805190602001906119c5929190611a23565b5060e0820151816007015590505086600060008b81526020019081526020016000206002016000828254039250508190555080600060008b8152602001908152602001600020600301819055508091505b5098975050505050505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611a6457805160ff1916838001178555611a92565b82800160010185558215611a92579182015b82811115611a91578251825591602001919060010190611a76565b5b509050611a9f9190611adf565b5090565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b611b0191905b80821115611afd576000816000905550600101611ae5565b5090565b905600a165627a7a723058205174be09369b890b572825b852b3f398c3596c17b7b1dcb1ed3f7d275af73a040029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"ID\",\"type\":\"uint256\"},{\"name\":\"Name\",\"type\":\"string\"}],\"name\":\"userInit\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"json\",\"type\":\"string\"}],\"name\":\"jsonsSmplify\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"m\",\"type\":\"uint256\"}],\"name\":\"uintTOstr\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"ID\",\"type\":\"uint256\"},{\"name\":\"FromTime\",\"type\":\"uint256\"},{\"name\":\"ToTime\",\"type\":\"uint256\"}],\"name\":\"jsonConcat\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"ID\",\"type\":\"uint256\"},{\"name\":\"Value\",\"type\":\"uint256\"},{\"name\":\"Time\",\"type\":\"uint256\"},{\"name\":\"Reason\",\"type\":\"uint8\"}],\"name\":\"tokenUpdate\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"ID\",\"type\":\"uint256\"}],\"name\":\"tokenQuery\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"From\",\"type\":\"uint256\"},{\"name\":\"To\",\"type\":\"uint256\"},{\"name\":\"Value\",\"type\":\"uint256\"},{\"name\":\"Time\",\"type\":\"uint256\"},{\"name\":\"Reason\",\"type\":\"uint8\"},{\"name\":\"Info\",\"type\":\"string\"}],\"name\":\"tokenTran\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"ID\",\"type\":\"uint256\"},{\"name\":\"newName\",\"type\":\"string\"}],\"name\":\"userInfoChange\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_a\",\"type\":\"string\"},{\"name\":\"_b\",\"type\":\"string\"}],\"name\":\"strConcat\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"ID\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"Name\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"TokenAllValues\",\"type\":\"uint256\"}],\"name\":\"TestUser\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"From\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"To\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"Value\",\"type\":\"uint256\"}],\"name\":\"TestTokenTran\",\"type\":\"event\"}]";

    private Integral(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private Integral(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private Integral(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private Integral(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static List<TestUserEventResponse> getTestUserEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("TestUser", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TestUserEventResponse> responses = new ArrayList<TestUserEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TestUserEventResponse typedResponse = new TestUserEventResponse();
            typedResponse.ID = (Uint256) eventValues.getNonIndexedValues().get(0);
            typedResponse.Name = (Utf8String) eventValues.getNonIndexedValues().get(1);
            typedResponse.TokenAllValues = (Uint256) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TestUserEventResponse> testUserEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("TestUser", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TestUserEventResponse>() {
            @Override
            public TestUserEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TestUserEventResponse typedResponse = new TestUserEventResponse();
                typedResponse.ID = (Uint256) eventValues.getNonIndexedValues().get(0);
                typedResponse.Name = (Utf8String) eventValues.getNonIndexedValues().get(1);
                typedResponse.TokenAllValues = (Uint256) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public static List<TestTokenTranEventResponse> getTestTokenTranEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("TestTokenTran", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<TestTokenTranEventResponse> responses = new ArrayList<TestTokenTranEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            TestTokenTranEventResponse typedResponse = new TestTokenTranEventResponse();
            typedResponse.From = (Uint256) eventValues.getNonIndexedValues().get(0);
            typedResponse.To = (Uint256) eventValues.getNonIndexedValues().get(1);
            typedResponse.Value = (Uint256) eventValues.getNonIndexedValues().get(2);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<TestTokenTranEventResponse> testTokenTranEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("TestTokenTran", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, TestTokenTranEventResponse>() {
            @Override
            public TestTokenTranEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                TestTokenTranEventResponse typedResponse = new TestTokenTranEventResponse();
                typedResponse.From = (Uint256) eventValues.getNonIndexedValues().get(0);
                typedResponse.To = (Uint256) eventValues.getNonIndexedValues().get(1);
                typedResponse.Value = (Uint256) eventValues.getNonIndexedValues().get(2);
                return typedResponse;
            }
        });
    }

    public Future<TransactionReceipt> userInit(Uint256 ID, Utf8String Name) {
        Function function = new Function("userInit", Arrays.<Type>asList(ID, Name), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void userInit(Uint256 ID, Utf8String Name, TransactionSucCallback callback) {
        Function function = new Function("userInit", Arrays.<Type>asList(ID, Name), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> jsonsSmplify(Utf8String json) {
        Function function = new Function("jsonsSmplify", Arrays.<Type>asList(json), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void jsonsSmplify(Utf8String json, TransactionSucCallback callback) {
        Function function = new Function("jsonsSmplify", Arrays.<Type>asList(json), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> uintTOstr(Uint256 m) {
        Function function = new Function("uintTOstr", Arrays.<Type>asList(m), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void uintTOstr(Uint256 m, TransactionSucCallback callback) {
        Function function = new Function("uintTOstr", Arrays.<Type>asList(m), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Utf8String> jsonConcat(Uint256 ID, Uint256 FromTime, Uint256 ToTime) {
        Function function = new Function("jsonConcat", 
                Arrays.<Type>asList(ID, FromTime, ToTime), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> tokenUpdate(Uint256 ID, Uint256 Value, Uint256 Time, Uint8 Reason) {
        Function function = new Function("tokenUpdate", Arrays.<Type>asList(ID, Value, Time, Reason), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void tokenUpdate(Uint256 ID, Uint256 Value, Uint256 Time, Uint8 Reason, TransactionSucCallback callback) {
        Function function = new Function("tokenUpdate", Arrays.<Type>asList(ID, Value, Time, Reason), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Uint256> tokenQuery(Uint256 ID) {
        Function function = new Function("tokenQuery", 
                Arrays.<Type>asList(ID), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> tokenTran(Uint256 From, Uint256 To, Uint256 Value, Uint256 Time, Uint8 Reason, Utf8String Info) {
        Function function = new Function("tokenTran", Arrays.<Type>asList(From, To, Value, Time, Reason, Info), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void tokenTran(Uint256 From, Uint256 To, Uint256 Value, Uint256 Time, Uint8 Reason, Utf8String Info, TransactionSucCallback callback) {
        Function function = new Function("tokenTran", Arrays.<Type>asList(From, To, Value, Time, Reason, Info), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> userInfoChange(Uint256 ID, Utf8String newName) {
        Function function = new Function("userInfoChange", Arrays.<Type>asList(ID, newName), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void userInfoChange(Uint256 ID, Utf8String newName, TransactionSucCallback callback) {
        Function function = new Function("userInfoChange", Arrays.<Type>asList(ID, newName), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<TransactionReceipt> strConcat(Utf8String _a, Utf8String _b) {
        Function function = new Function("strConcat", Arrays.<Type>asList(_a, _b), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void strConcat(Utf8String _a, Utf8String _b, TransactionSucCallback callback) {
        Function function = new Function("strConcat", Arrays.<Type>asList(_a, _b), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public static Future<Integral> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Integral.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<Integral> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Integral.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Integral load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Integral(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static Integral load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Integral(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static Integral loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Integral(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static Integral loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Integral(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }

    public static class TestUserEventResponse {
        public Uint256 ID;

        public Utf8String Name;

        public Uint256 TokenAllValues;
    }

    public static class TestTokenTranEventResponse {
        public Uint256 From;

        public Uint256 To;

        public Uint256 Value;
    }
}
