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
public final class Counter extends Contract {
    private static String BINARY = "6060604052341561000f57600080fd5b6040805190810160405280600b81526020017f49276d20636f756e7465720000000000000000000000000000000000000000008152506000908051906020019061005a929190610068565b50600060018190555061010d565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100a957805160ff19168380011785556100d7565b828001600101855582156100d7579182015b828111156100d65782518255916020019190600101906100bb565b5b5090506100e491906100e8565b5090565b61010a91905b808211156101065760008160009055506001016100ee565b5090565b90565b6104f28061011c6000396000f30060606040526000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063146af82b1461005e5780632cefeb0714610087578063c6ea59b9146100e4578063d8c1b1801461017257600080fd5b341561006957600080fd5b6100716101d8565b6040518082815260200191505060405180910390f35b341561009257600080fd5b6100e2600480803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506101e2565b005b34156100ef57600080fd5b6100f7610298565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561013757808201518184015260208101905061011c565b50505050905090810190601f1680156101645780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561017d57600080fd5b6101d6600480803590602001909190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610340565b005b6000600154905090565b80600090805190602001906101f892919061040d565b507f42b90959a8e5381997923014ade0202cf9a119d14c27a3304fa5faabba36128f816040518080602001828103825283818151815260200191508051906020019080838360005b8381101561025b578082015181840152602081019050610240565b50505050905090810190601f1680156102885780820380516001836020036101000a031916815260200191505b509250505060405180910390a150565b6102a061048d565b60008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103365780601f1061030b57610100808354040283529160200191610336565b820191906000526020600020905b81548152906001019060200180831161031957829003601f168201915b5050505050905090565b6000600154905082600154016001819055507ff27afe48774ff6727d9d80f14cc0557905314c3b842d6e333720f07567d520318382600154856040518085815260200184815260200183815260200180602001828103825283818151815260200191508051906020019080838360005b838110156103cb5780820151818401526020810190506103b0565b50505050905090810190601f1680156103f85780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a1505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061044e57805160ff191683800117855561047c565b8280016001018555821561047c579182015b8281111561047b578251825591602001919060010190610460565b5b50905061048991906104a1565b5090565b602060405190810160405280600081525090565b6104c391905b808211156104bf5760008160009055506001016104a7565b5090565b905600a165627a7a72305820d6c8fbf43ec4773d3b0a0787acae10fc433ee3ca311625cd16752c7a8ee978640029";

    public static final String ABI = "[{\"constant\":true,\"inputs\":[],\"name\":\"getcount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"n\",\"type\":\"string\"}],\"name\":\"setname\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getname\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"c\",\"type\":\"uint256\"},{\"name\":\"memo\",\"type\":\"string\"}],\"name\":\"addcount\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"c\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"oldvalue\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"currvalue\",\"type\":\"uint256\"},{\"indexed\":false,\"name\":\"memo\",\"type\":\"string\"}],\"name\":\"counted\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"oldname\",\"type\":\"string\"}],\"name\":\"changename\",\"type\":\"event\"}]";

    private Counter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, isInitByName);
    }

    private Counter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, Boolean isInitByName) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, isInitByName);
    }

    private Counter(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    private Counter(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static List<CountedEventResponse> getCountedEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("counted", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<CountedEventResponse> responses = new ArrayList<CountedEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            CountedEventResponse typedResponse = new CountedEventResponse();
            typedResponse.c = (Uint256) eventValues.getNonIndexedValues().get(0);
            typedResponse.oldvalue = (Uint256) eventValues.getNonIndexedValues().get(1);
            typedResponse.currvalue = (Uint256) eventValues.getNonIndexedValues().get(2);
            typedResponse.memo = (Utf8String) eventValues.getNonIndexedValues().get(3);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<CountedEventResponse> countedEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("counted", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, CountedEventResponse>() {
            @Override
            public CountedEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                CountedEventResponse typedResponse = new CountedEventResponse();
                typedResponse.c = (Uint256) eventValues.getNonIndexedValues().get(0);
                typedResponse.oldvalue = (Uint256) eventValues.getNonIndexedValues().get(1);
                typedResponse.currvalue = (Uint256) eventValues.getNonIndexedValues().get(2);
                typedResponse.memo = (Utf8String) eventValues.getNonIndexedValues().get(3);
                return typedResponse;
            }
        });
    }

    public static List<ChangenameEventResponse> getChangenameEvents(TransactionReceipt transactionReceipt) {
        final Event event = new Event("changename", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<EventValues> valueList = extractEventParameters(event, transactionReceipt);
        ArrayList<ChangenameEventResponse> responses = new ArrayList<ChangenameEventResponse>(valueList.size());
        for (EventValues eventValues : valueList) {
            ChangenameEventResponse typedResponse = new ChangenameEventResponse();
            typedResponse.oldname = (Utf8String) eventValues.getNonIndexedValues().get(0);
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<ChangenameEventResponse> changenameEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        final Event event = new Event("changename", 
                Arrays.<TypeReference<?>>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(event));
        return web3j.ethLogObservable(filter).map(new Func1<Log, ChangenameEventResponse>() {
            @Override
            public ChangenameEventResponse call(Log log) {
                EventValues eventValues = extractEventParameters(event, log);
                ChangenameEventResponse typedResponse = new ChangenameEventResponse();
                typedResponse.oldname = (Utf8String) eventValues.getNonIndexedValues().get(0);
                return typedResponse;
            }
        });
    }

    public Future<Uint256> getcount() {
        Function function = new Function("getcount", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> setname(Utf8String n) {
        Function function = new Function("setname", Arrays.<Type>asList(n), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void setname(Utf8String n, TransactionSucCallback callback) {
        Function function = new Function("setname", Arrays.<Type>asList(n), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public Future<Utf8String> getname() {
        Function function = new Function("getname", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallSingleValueReturnAsync(function);
    }

    public Future<TransactionReceipt> addcount(Uint256 c, Utf8String memo) {
        Function function = new Function("addcount", Arrays.<Type>asList(c, memo), Collections.<TypeReference<?>>emptyList());
        return executeTransactionAsync(function);
    }

    public void addcount(Uint256 c, Utf8String memo, TransactionSucCallback callback) {
        Function function = new Function("addcount", Arrays.<Type>asList(c, memo), Collections.<TypeReference<?>>emptyList());
        executeTransactionAsync(function, callback);
    }

    public static Future<Counter> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Counter.class, web3j, credentials, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Future<Counter> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger initialWeiValue) {
        return deployAsync(Counter.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "", initialWeiValue);
    }

    public static Counter load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Counter(contractAddress, web3j, credentials, gasPrice, gasLimit, false);
    }

    public static Counter load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Counter(contractAddress, web3j, transactionManager, gasPrice, gasLimit, false);
    }

    public static Counter loadByName(String contractName, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Counter(contractName, web3j, credentials, gasPrice, gasLimit, true);
    }

    public static Counter loadByName(String contractName, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Counter(contractName, web3j, transactionManager, gasPrice, gasLimit, true);
    }

    public static class CountedEventResponse {
        public Uint256 c;

        public Uint256 oldvalue;

        public Uint256 currvalue;

        public Utf8String memo;
    }

    public static class ChangenameEventResponse {
        public Utf8String oldname;
    }
}
