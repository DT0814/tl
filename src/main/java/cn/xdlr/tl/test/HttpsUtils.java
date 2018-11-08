package cn.xdlr.tl.test;

import cn.xdlr.tl.pojo.result.LoginConfirmResult;
import cn.xdlr.tl.pojo.result.LoginRequestResult;
import cn.xdlr.tl.pojo.result.SimpleResult;
import cn.xdlr.tl.utils.JsonUtils;
import cn.xdlr.tl.utils.SHA256Utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;


/*
 * GET请求类
 */
public class HttpsUtils {
    private String url = "https://222.25.188.1:50118";

    //  private String url = "http://localhost:8080";
    @org.junit.Test
    public void PutUserStateTest() {
        SimpleResult result = PutUserState(1,
                "KgSZcy3l3ZbKPtHTHUXrfe3IrkGtVUrbIUbfQyRf9e6HqYD8EJ6Q0xZj8Ct3JwQ1PbnCeBgezcyOXpDDOuureOGIjvlGGrrm6NZRtImHb5uMhGMlvEeOrWKxDsCp34I9",
                "sdadsasada213sad123",
                "入口",
                "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAYAAADDPmHLAAAb1klEQVR42u1dB1wUx/dfr3D0KqAi\n" +
                        "IoqoINgLakAFVAQ0IEpTmnSOThBUIvaKJfausUWNGo011qjYUKMxamwxiT+TmPxjNJZY4N5/Zm8W\n" +
                        "h+XAE0MSbm8+n/cR9+5md9/7zmsz84ZhtE3btE3btE3btE3btE3btE3btE3btE3bNLPVewfStjou\n" +
                        "aJEKEldD/O9qQVGHBM4XsIRHUh7pUMT/jP4dHxxaMPxHBK9K4LRwZYR0EekR0n8Dcd/TJcT1oUMB\n" +
                        "gwaEFgz/wmgX8QSuwxM0FqQBIkNERoiMEZkjqo+oAaLGhKwQWVJkhsiEkDH5rSHpS58ChoynJcRV\n" +
                        "mAttq6XRLuEJnRO4CRGqLaLmiNogeg9RICMWxzIiSZ5IR2eaVM9grkSmN1sk0ZkikkjGo+v5jEiU\n" +
                        "jrqOQN99n/zGFVELRHYENKakfyMKEHwwiNXwH7TgeAsPXVTFaOeEbkiEg4XdAdEQkUhSqGNovKl+\n" +
                        "85Ylzd297nUIjXrqkT36le/UjxTByzZC1JZ9MGLnEYj57CD79/ANOyFk+ScQMGcZ9C+coXBPy33Z\n" +
                        "Lnj4Y/uevX40s216Sqqrvxo9Qgbq2wuRM6KmiCx4YNBTYSb4/kNVfoRWnVfjnUt4o12PMNyajM5+\n" +
                        "aARPM7W1O+bsN/j3PrkfloWu3ARJB89C5tnrkHXuFmSfrxllnbsJGaevQdyuYzBo1hJFp4i4v6xa\n" +
                        "O38lkUrnovv6EjA0pMyGoQozQfsPOjwHUyxUIKiy4xIVnrmMp+KNiN12Qyr7Q+tWbUq6jkh5Fbpy\n" +
                        "Myuomgr6bSjz7A0IW7MNOobF/GVo3Wg/epYoYmYaEh+DNhOc/0D7ENWZjXpCFLwq542z57QTxwpe\n" +
                        "LNOb59DL+7eghR8r0k9dVUNot2sFCFizJB0sgR7J2S/0zS2/QM82EJEjMUeY7ImG6EKoDTEd5irM\n" +
                        "hlQIIKCFz412GREwVudNiB1vSoRtQZhlxTIP2fVmHl6/hK3ewqrmf2K0Y0o/+Q2kHDnPUvqpKyq/\n" +
                        "g01Eq/6DHiLfYzJ61m6IBiMnc22Trt1vtg+J+rPTsNinDr363pWZmGzFPgoBihmJMgwI+DkQaKw5\n" +
                        "oIWvQ14ce9e+Iql0tnlTh/02bTueMbdvfkAslc1H14OJF+5j1NDmyIAJRWVY/VYc1beR6v+WtfeJ\n" +
                        "B05D2onLKkb9bTW1wu3ykR25eS/0SR8JwfJ0yMofDROmTIHxk6dA+sh8CEhKBa+RhZCE7kf3g5/N\n" +
                        "M39CqY6R8RnXwJCn0dsOUv6H8ntxu49D+9Cov5AWW0DejXMkVYFAo4WPkd9B19h0bYewmOfR2w4o\n" +
                        "MpA6zyq5wdrymO0HoWtsyks9M4ujth3d7sV+flSRfe61Yxa760vom1cIvjHxkJCeCQXjxkPhhImQ\n" +
                        "mv0BDIwaAX3SPmCF+LaaIn7PcegdnQDTi4rg559/htLSUlAoFBXo1atXcO3aNYiVp8KA8TNZR5N2\n" +
                        "GoMWrIZ2Q4ZBRhXmCX/HZ+IshdTAAEUWjAvJS3AgkBEeaZQp4FSamAgfq/wuFs0cSsJWb63SSw9b\n" +
                        "sxVcA0NBfuxi+bXkw+egV7wcxk2eDDdu3oSysrJKAsJ07949KJozFzxiktjfvNGeIxqyeC3EyNPg\n" +
                        "l/v3VfbJJ3zvbdu3Q++kDBa4dH9Dl26ADmFRFcDBB0FPec4rRiTKRbxoRkBgTHwfHU3TAvTox2qu\n" +
                        "hYGl1f6ITburFEjEpj3gGhBMqfRbbLweGB0Lt27dUktAmG5/9x0MjIxhVW91AAhZsQlyRo2Gly9f\n" +
                        "Vtsfbvxrn+3YAT5jp1bq03/6fHDyCwRn/8HQO6egUpSSfvIKWLV0vob40YM4jeZkcNBaQGMAwI1+\n" +
                        "C4T6VO/Rk8poZsi/vMiqfTzakw+dAyffAEg9folyso5DcEwsPHn6VG3hc/T7779D3/AISCv+RqXw\n" +
                        "Uw6fh+DY+DcKvzpNIM/KgYR9xZVGeeeIeJDo6LLknjay0r3dM/LKEE9iiC9kSbSAHvEFNMIM0KMf\n" +
                        "I7u5mV2zY2knvq4w2s1sm4JUVw+MrBuBbaduEL31wGvnCqlXz8hY+PXXX2skIEwlJSXgjXwGVQDo\n" +
                        "k57H2vSa9o0Ja6U+GXmsKaH7xqCzbu3CAsDS0amST4KzjyKJZBYVPppqmhngACAlyO7aZtCQxzQT\n" +
                        "UExfPkoweeWPr2hPl22AFStWvpOA8CgNi0tkQ7qKAroMEUkp7OeYsMlYtXoNHDp8mHX23qb/kJQ0\n" +
                        "5AtUtvlBiz4GiUwXHDy8KgEgEoFfLNVZgfjSmkokcc6gxgCAU/8Y2X7dYuUKjgE5iOo3b1ku/AbO\n" +
                        "7ZD3XDHW7pOQBo8ePWIZjR2/UaMLIDU9HQ4eOlSlE6iK1m3YAKGrtlToO3ztZ/Dx2nXs57t27wFj\n" +
                        "U/PyZ4mKiXkrEBROnATyoxcqa5lzN8DRawBEbtlb6bPBKGIQiSSzSZKoEc8P0DgAYGT36xAa9aqC\n" +
                        "gHML0QjRY5n+/uwlQIMDj5jw1ExW0HfufA+Nm9iVC0hX3xDWb9iotoBu3LgBfcdMKu8b/+s7ZS6c\n" +
                        "P3+BFXRrZ5cKmkiKnukQApm6/a9YuRJith0o75u+D55k8p++oMI1TJ0j4l4iniSSOQ2NBwDWAF0a\n" +
                        "unS4lXnm2mshIxs/YOIsaNCmHQqbvq3oSKEwKi1vFMvgzKzsCgLC1K59R7VH6W+//Qbe2WMq9I+9\n" +
                        "d2y/sX9B9+vWoye079AJimbNVl/DrFuHIpW9Kv2M1ONfQ9vBYUgbvDYBWCPompoV40FB0sbcpJKB\n" +
                        "pvkANACai8TS+f4zFijo0RCOYn4cKtHXcggAUgkAAoOGlAuokY0tzEFxvo1tE3iqZmSgBMBotl+O\n" +
                        "BqJQ7fTp0/Ds2TMwr29V3v96ZC7mzV+AzMNatQFQNHs2JO4/VaF/mjqERqIIp4T9e8SOwwpLx9b/\n" +
                        "Q/yQk2RQE5LyNtF0JxAjvJ++hWUJsscKdkQg6hKdyObTVSVMItKzWRMwpqCgXEBObVzgytWr4N2v\n" +
                        "v8psnSrCnn6/DyvG67E7j8LkadPZz/PyR5X3b2FphTRARzaEVBcAMRnZ1c5IBs5bCf3HzQDPkYWl\n" +
                        "hvWtryI+5JIcAJ7/sCHJICOSK9GYbCA/CcTN6g3VNTI50j0xozTxi9Ns6jRbVdoWXfNKSIUnT57A\n" +
                        "/fv3oY1r23IhYYdt/xdfqC2gBQsXQcQnuyoCDJkfr4gYVos8f/4c5sydCwN8/SAxKRlu376tdt93\n" +
                        "7tyBXsmZqM+qU884r6FvZvF/6N1XIoojK45akcmvBpT65xJBGpUJpM2AKbF5/ohm6JqYXXVPy63E\n" +
                        "MM4UBM5dAZs3bylX4/MXLIQpU6fB5cuX1RbQ8+cvwGdYNGtS+I5Y8NINsGTZ8hqHmFgDxcrTIH7P\n" +
                        "iUp95/DAbN/D/T565wgyY4g9fwcyIOrzkkAamQqWUlrAgti9nsgnWB68/JMqR04Gchj7R0SzWqCm\n" +
                        "OYDFS5fCEBSP06YFgwEnmfDfHolpcKK4+K3CSk74s5Av8v6sJWpNNnWLk5eid05mlEvXWlcz+jVu\n" +
                        "XQA/HDQlawDa6ZqY7+WcI74TyP09bMNOyMkfrba9p2nP3n3QOzWHHYFpSA17orCzubsnNHByhcbt\n" +
                        "OkP74EhkGnZDn/hU2P7ZDrVB8PDhI8jKy4eB0+axfVfl/NE0qGgxMCJREXrvTiT7Rzt/Gjn6q9MC\n" +
                        "WO11tGrlfF2V/c/hO1EfrUAMHwWPHz9WS0AvXryABYsWg2dGHjsrl3TgDCt0fiiJSc/UAvCyMp9x\n" +
                        "0yE2LQOKT55UOTeAAfjTTz/BfORPeEfFVxn2VUWxO49APbFkCzEBtPrXOOevKhBIqFVAOOnRo2Vf\n" +
                        "34fqMfAmRG7aDd7hkfDJps3w4MGDSqMV/x977ls+/RR8kXM3dMk64CINPD2rSvgcOfsFKp21Y5cQ\n" +
                        "EGZAr+ExEJmaDiM/LIT8wgmQkpsH/jHx4J6cBVE1WGvAmrNTV8Cogc1p9N7ulPdvwZsF1OglYXxn\n" +
                        "0L9zZPyLHBXMqupa5plvkWDXg7c8G4KT5CDPyoac3JGQjP4dmpwK3kjdY8eOC8ky0b+Dp88Da/vm\n" +
                        "1QLAsW1bCEf9cuo8m9wLmw1MGSevlEcqOSqesbprtCPYpHP379F796UAoHHZP3XMgD5xfKLwMu4a\n" +
                        "L8xkVxBdZUcWFjh/VKafuAz+kZHw+ZKRcGhtAbRo1riS4C3rm0NmjD/cO74Qlk1KBt9EOaQdu1Rr\n" +
                        "awxdAoIfovcOICaArwEEAwA9JfJFGX5T5ynUHUk56o40Qn5ZeXB6y0R49vUalh6cWw5HEBBWTkmC\n" +
                        "lVOT4DD6+/6pJfCUfI7/Pbt1MvhGRrGaozYA4BafivP/kVUAQCIkAODFIWOCFq5RvI0JyFYTAFh9\n" +
                        "J8SFwNNLq8sBoC7tWDwSgmYuqBZcNSXPvPEK9O7pJAlEO4GCAgA2AQ1FIsnE0FWb35mpqoSEF53k\n" +
                        "pw9/a+FjundiIQyQZ9aKBsBLxRAbxqL3d2KU+xcteVGAYABggwAwLfzjbWqP9py3+Bw7XIMihrEq\n" +
                        "nhMs1gbX9s2C1dPkMCEzHOYWxCIz8CH8gUwDDYCt87NhSNGiN5ofda/Rf+PIhKwBcCV5AG4pGB0G\n" +
                        "CgsAtaEBMI3Ysg/CQwOQvU+BmfnRkDoiFOYUFUHxiRPg7z8Q/nf3LmxFIWNqfCQU5UfB8Y3jYcWU\n" +
                        "FPBNSK40Nf130bD1O0AslS0j2UA7FYkgkaA1wN/pBLKmAIVwHsmZsH///vK1A3jZeASKDrj8AZ4M\n" +
                        "aucXCENnL4UIvPOo5HqtRQF48atUV28DToKRVLC1UAHQCAFgUsjKTfB3OYFVXeuTXcCu9ytfHXTz\n" +
                        "JiQlJ1eYLHKPjKtR32+VB0CUsLcYdPT0t5F0MDcXwK0D0JjVwOoAoD4jkowdsnitorZMQPnKn3Ez\n" +
                        "4MzZs+UC/+abKwgAKRV2+3jFxP8jew3xNjaZkfEeBu9wVs6K0quBBQUAHAbmDpy5SPF3OFjVUcTG\n" +
                        "z9lZO07g16/fgPiEhAoA8IyOU2tC511JfuQ86JuaHyCLQfgA0BEWABiRvP/YaWW1rQHwZFCPgCHw\n" +
                        "44934f79XyE4Khra9RvArinAEzynTp+GnvGp/4gGSD12EfTrWx0jC0LotYAauS3sDZlAJtIja1TZ\n" +
                        "uwo7R82Nn93Do8EtLAqit+5nBdE9Kh68h4SAO3ISU49f/GcAcPxrMLRqWEwA0ExIAGB4AMCOT2DX\n" +
                        "mOSX72oCak43q9zAWZsAMFICwJ0HAAOhAEBCAaBf26DQZ/+kAP5twptCjRs2Pove3UPIANAl2a/u\n" +
                        "LTx9HgoJAHjW0tTG7jwFAG5DiCAB0Mm2s9tdAQOgudAAUI+puES8XX2Hlley/8GaP1oA/DcAICMA\n" +
                        "cDJu1LgY79p9l4ybFgB1FwAtdU3MdqeoUcZFwzTABS0AlKtg7KV6Buvidn0pZAAIbl0gDQA7sUy2\n" +
                        "MGLjLsEAAK9bNLdvfpkAQFDLwlTtE7TDdX5Dlm8EIUUC5k0d8ObQXoyyLgB/b4BGTgjRpeK4TKAx\n" +
                        "a/9EooKAucsF4wSyALBvgauDeWIfiFG9NVyjNojwS8TKiMNjpkS/6AO/yXMEpQEaOLveRu/uwyj3\n" +
                        "B3ITQlwNYXqLWJ0HAT3yOeGTmUB2OZQresd0/r59TadGrh1wcQi8NByfP9CZZAStyLSwIaNBtYP5\n" +
                        "Ix/bOrwcOlYkFi+3qm96sHEjy0t9x0x+p0WhdY1c+niWZcb4/TXQu8tPxsYG+xA/UnBSjHm9PIzb\n" +
                        "KVynN4vy6wPbMGJxXJe2jt9+NCZKcX3/LHYF7rV9RdA7a4ygNECPwMDyFcg/FS+C8elDFQ0szXfh\n" +
                        "uRGeP1Cnt4vTTp+VSCTKyo0f9PxBScUl2N8SAAjJCewWFAx/XlhZgQ/HNoxVmJmwS8VcKH+gTlcQ\n" +
                        "pzeDdvP37Pzb469WVdqEcebTieCVP0FQGqD78Gj45eTich48ubgKMG9Gxr//AvFqKKPcK1CnC0bx\n" +
                        "bf/gvMSAl6umJcPFHVN527A+gL4FUwQFgJ5xcuBMIKavEE8iAnuBj0f7PxGvQokvUKdrBvGTPp0k\n" +
                        "Uumh6bnh8CfRAr+dWQoTMoJLbRpa/ur7hjCwpsvA/qvknj5S4eRo93AnAv/ji0p+7Fk2EkQi8SbE\n" +
                        "q67M67IxhpoAABlBdFpCmPfL4xsLoWhURJlTC7sf0LX5jEi0HFf/EJIGQGFvGWLPcrFEsrNrO8df\n" +
                        "ksL7vnRpZfcjo6wc3ozwy5Sp41XD+IkfvBNmHAr/1qN/ZzDK07b80f8XsvX6BeQEDpyxUIGAP4uo\n" +
                        "e1w0aiSiaMIjG03wAfhOIFckshVJfOCYF++O7SzW0V2NS64ISQMMWbIeAUA8j0wIdSaCb03SwtbU\n" +
                        "7GCdjwL4WsCEJIMakkxgex09/S0JpMaeUGjYus+wvccbRLnjaXHFsKaELxZMxeNj6nQeQETlAnQJ\n" +
                        "qjkQ4IUQ7fXNLfbLj1wQlAnAVcWR6VtLEj9OxO7Tql9jagbyzwnkQGBKXratiY3tqQy1DoDUHMIb\n" +
                        "ROuJJZsZZbm4lszrw6nNNG0uQFVKWI9kubCda2/p6HRVSItClecUnQOxRGc7o9wgytULpM8M0mE0\n" +
                        "6CTReipAwJWJ62Dbye1HIQlfeUjWVyAzYNO+dLVwC0bDC0by9wZiW9fJoU//B0IDAFs53NQC7xDu\n" +
                        "yVTeHKKx6wL52UGs7nq5DBr6JOf8LUE5gfg8RANL6yMUAASzPYwPAJ+Ow0Y8F5oGIAA4qgUAwwS4\n" +
                        "JaS/0gJAOFvE6d3B2AkM98gcVSZIANTXAgA5PeIYr7zxggMALk4hMzbZL1QA0LWCU3zGzywTmhOY\n" +
                        "cuQ8PivxcxIGqgKASCgAkPtMLFIITQMk7DsJ9cRifHAELhUnmEphqqqFp/pMEB4AIjfvxZNBq4QG\n" +
                        "ANUaYMJMxbvWCq5rNHTpBgUjkszFqXDmdbVQIQJAHOuVN05wTiD2exArChnl0XF2jIDKxdIAYMNA\n" +
                        "97Tc0myBOYHd49Pw8XEpZIEM/+QwiaYDgK4SNgifGSQ0DdDaZ9BT9O7BzOuj4wRTMp6fCezj7B/4\n" +
                        "REjCx/UBrFu3+Z5Rbg7lbw8XxKkhNAC62HXp/vOb1LkmLQvHh2TqmZp9ySjrA6g6Ok5QNYJcTZs0\n" +
                        "vVBbBzT9JyOAxevwcrClGPyMAAtFciuFuRIxjjqGhp/G7z4uGCewZ3I2dgCzGeUewKaMgKqF0wDg\n" +
                        "zhC2FYlEk4SyMSRLeXDkPfTeQ5jK1UH0ND0HwAeAPnF+wrvFygURCYzYcQTEMt0v0Dv3ZiqfHSzT\n" +
                        "9AhAVToYI/+9hq4db+FTQDXdBLhn5Jeh953AKA+M4uy/xi8Fqy4UxMhvJZJKP8FHuGvy6Mdl6a1b\n" +
                        "u3xP1H8rKgMoiBRwVZGAIXGCEjpHJbzUZAAEzlvJbQZxZ6o/Op4RAgD4p4j3MLJueFZ+9IKGjv5v\n" +
                        "wa5bzwfoPUeQ/L+9UNU/7QfQCSEcDuV1T0gr1UQADJq1RCESS/Gu6D5U+ldQ3n91ZsCAjAR3PXOL\n" +
                        "YnywokbtAjpyHsztHe4wyu3wbZiK+wAMheL9V2UGuBPETMioiLXv4fG7puwVxJGNy/tDn6H3msQo\n" +
                        "1/9xsb81L/kjFtLoV2UGuL2CKDwSzeiCHEIuLKzLSR/3jFFlyPHbiN5rIBn9XO5flfMnKABU5Qzi\n" +
                        "iMAThYXr8HFyWXV00yh+7n5jp5VJZLq4CORwRrn0i18WVuOrg79tUsiYzItjhzCgnkRnZ7e4VAX/\n" +
                        "FO//egIos+Q69M7MhxD/98qMjAwOk3n/jlXE/oJU/9UBAKvGtvhI2T5urvfnjolSuA0NgaRDZ+uM\n" +
                        "w+cWMgxWTUuCp5dWw76VeYqG1han0Tv5Ew2gBcAbAOAik8mWFqQMfvHHueXw9OvVcHHnVOjv5wm4\n" +
                        "pHxtHuv+rs7e4AWrwMvXE85vnwLPkPC5GoCH145RmJoYH2SU9YC0AKgGAI7GxoYbP56RrHhKMRDT\n" +
                        "H+dWwJyCaOgRFATD1u+A/4pvgJ9j+Iad4ODZvywupC9g0PIroWJaPD6uTCSR4EjAmXldCcRAC4DX\n" +
                        "TqAlUvs5HxVEKfCof3RhhUpG/nB0HgT07w4tPPtD0MI1kHHm31lIgu8btGA1OHr5PBbLdI+i559l\n" +
                        "Zmp0cev8TAX9vFf2zIRLn0+Dh+dXQOd2jt+TUFDrBPIAgJnQ3Lml3WlcQLl40zgoyh9eQfBPL62B\n" +
                        "kq2TFL3cXP6QSCR4T93CemLxVjN7hx+6xqa8Cl+3Q4GPnqutUjN4pKcVX4aw1Z9Cl+jEl2ZNm31P\n" +
                        "dvbkEifPG1G8ibHB2YNrRpeD4OeTiyBsoDtbBzgz2u8VmQjCSSALIU0Bq5MNdPLo5nzjQckyCPXv\n" +
                        "yTKuXPhII6yYkqAwMzU+h743ilEWU/YmsfUINskiFm83a2J/tVX/gU96ZY9WDF26ARK/OF1jU4Fn\n" +
                        "7uJ2H4PB81fBe6kfQEuvAX8aN2ryDb4Put9kcl9fRrmsy4XE+LjeX2yTRpZXz382pfz5FxSOgF1L\n" +
                        "cyGgX1e8EngQDwC6WgAQDWBoqL9tbNoQxfpZqeXMwxqhQD74lURHgmvpRxMV6kpsaWvCfCyEfojC\n" +
                        "EKUyuAppPfFmiZ7+MRMb26t2XXv+1Nr3/UcdwmKeu8WlliKBlvbKHlPGUtbo0p7JWaVdoxNL2waF\n" +
                        "P2vZ1/eBTdtOdw0trS+jGP4IMkufoP6mI0pDNIxRruTtRu6Lc/otSHKHI7zTJ8nBvtEd5Ayyvsx3\n" +
                        "h+ZCSwfbl1KpdA35LX08jBYABADYKQoUS6SHV0xOUDxCgv8KjaIBHh0fiUSiJUR1tiOxNMd0e5Iz\n" +
                        "4AhfdyJJl94k9AohwMGbMDIRjUY0noziySRFW4gnosjnKSRnH0o0DD7SpSsbmir7diC5/KYkpduY\n" +
                        "ZPY4siUARebA6GTQALdH7Z2b3UVAmkvAY0cmgep0JfDaygRiBvqhMHCzS8um1wwN9LGtzyEzaK2J\n" +
                        "0JsSJtsQb7oBCasakJFlQ4TShADEgeTfnYhg2pOkTGeKOipT0Oznbch3W5Lf0kDjBN6I3M+S5C0s\n" +
                        "CNUn1xqQ3w8g4MNgcmNeLwDlVwIVfBTAhYFGhLndyej1JgLhmG9DMd6CjCJTiswoQVjxQMGNTlvS\n" +
                        "l50KakLIlhrZjUgf1pTAzcn9TMgzGxGP3ohcMyPfa0D12YA8kwXzuhKoxp4RWJMJIe40MWPCYGtq\n" +
                        "ZHPM45jPMd6A/IYjA54gOFCY80aoJelPFVnyRrY5BTRjStj6BLS65Nll5G/uOWgwmFOgMaaEr3Hn\n" +
                        "A76rFuBAwGceLQCO+RzjdXjECUJPBSiMSB/GpH9VZMwTtAEFND3efaVEgDRxz8Dd35AiA+rZtcLn\n" +
                        "aQEaBHzh0QKQUcyTkN/RxF2X8kDBAYMDR3WkyxvZOioEzpVx5ZOYd3+Zir6kPOELGgB8EPCZp4px\n" +
                        "Yh7z+EQLQ6xilErfQJIqACZ6w31V3V9SRX9a4asAQb1qBCeuQvBV9VOVUN6GqhOyOu9ST40+ta0a\n" +
                        "4VUniHftW136O99HK/R3YJ62aZu2aZu2aZu2aZu2aZu2/R3t/wHWz8y1dvsgpQAAAABJRU5ErkJg\n" +
                        "gg==", "2018-11-01 12:12:12");
        System.out.println(result);
    }

    /**
     *
     * @param cid 客户端id
     * @param Acode 客户端授权码
     * @param uid 用户id
     * @param Ustate 状态 入口 出口 售货机
     * @param Uimage base64编码永固
     * @param Utime 触发时间2018-11-11 12:12:12
     * @return
     */
    public SimpleResult PutUserState(Integer cid, String Acode, String uid, String Ustate, String Uimage, String Utime) {
        String PutUserState = new HttpsUtils().doPost("cid=" + cid + "&Acode=" + Acode +
                "&Uid=" + uid + "&Ustate=" + Ustate + "&Uimage=" + Uimage
                + "&Utime=" + Utime, "/user/PutUserState"
        );
        System.out.println(PutUserState);
        return JsonUtils.jsonToPojo(PutUserState, SimpleResult.class);
    }

    @org.junit.Test
    public void loginTest() {
        login(1, "123456");
    }

    /**
     * 请求认证
     * @param cid 客户端id
     * @param pass 客户端密码
     * @return
     */
    public String login(Integer cid, String pass) {
        String request = new HttpsUtils().doPost("cid=" + cid, "/cli/request");
        LoginRequestResult loginRequestResult = JsonUtils.jsonToPojo(request, LoginRequestResult.class);
        String confirm = SHA256Utils.sha256(pass, loginRequestResult.getRandom());
        String result = new HttpsUtils().doPost("cid=1&confirm=" + confirm, "/cli/confirm");
        LoginConfirmResult loginConfirmResult = JsonUtils.jsonToPojo(result, LoginConfirmResult.class);
        System.out.println(loginConfirmResult.getAuthCode());
        return loginConfirmResult.getAuthCode();
    }


    public String doGet(String param, String url) {
        HttpURLConnection conn = null;
        BufferedReader in = null;
        PrintWriter out = null;
        this.url += url + "?" + param;
        try {
            conn = getConn(this.url);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.flush();
            return getDate(conn.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }
        return "";
    }

    public String doPost(String param, String url) {
        HttpURLConnection conn = null;
        PrintWriter out = null;
        this.url += url;
        try {
            conn = getConn(this.url);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            return getDate(conn.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private HttpURLConnection getConn(String url) throws Exception {
        HttpURLConnection conn = null;
        trustAllHttpsCertificates();
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
        conn = (HttpURLConnection) new URL(url).openConnection();
        return conn;
    }

    private static void trustAllHttpsCertificates() throws Exception {
        javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1];
        javax.net.ssl.TrustManager tm = new miTM();
        trustAllCerts[0] = tm;
        javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
    }


    public String getDate(InputStream inputStream) {
        String line;
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder sb = new StringBuilder();
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
            }
        }
        return "";
    }

    static class miTM implements javax.net.ssl.TrustManager, javax.net.ssl.X509TrustManager {
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public boolean isServerTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public boolean isClientTrusted(java.security.cert.X509Certificate[] certs) {
            return true;
        }

        public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }

        public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType)
                throws java.security.cert.CertificateException {
            return;
        }
    }
}