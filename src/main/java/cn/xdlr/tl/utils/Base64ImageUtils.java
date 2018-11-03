package cn.xdlr.tl.utils;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64ImageUtils {
    @Test
    public void fun() throws Exception {

        //本地图片地址
        String url = "D:/a.jpg";
        //在线图片地址
        String str = Base64ImageUtils.ImageToBase64ByLocal(url);
        System.out.println(str);
        Base64ImageUtils.Base64ToImage("/9j/4ABuW0lEOjQ0MjFdCltmYWNlIHJlY3Q6MC4zMzc1KDApLCAwLjM5OTEoMCksIDAuMDI2MCgw\n" +
                "KSwgMC4wNDYzKDApXQpbZmFjZVNjb3JlOjQ5XQpbY3VySWR4OjBdCltKcGVnUXVhbGl0eTo0MF0K\n" +
                "/+AAEEpGSUYAAQEAAAEAAQAA/9sAxQACAQEBAQECAQEBAgICAgIEAwICAgIFBAQDBAYFBgYGBQYG\n" +
                "BgcJCAYHCQcGBggLCAkKCgoKCgYICwwLCgwJCgoKAQICAgICAgUDAwUKBwYHCgoKCgoKCgoKCgoK\n" +
                "CgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoCAgICAgICBQMDBQoHBgcKCgoK\n" +
                "CgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCgoKCv/AABEIAMQAxAMB\n" +
                "IgACEQEDEQL/xAGiAAABBQEBAQEBAQAAAAAAAAAAAQIDBAUGBwgJCgsQAAIBAwMCBAMFBQQEAAAB\n" +
                "fQECAwAEEQUSITFBBhNRYQcicRQygZGhCCNCscEVUtHwJDNicoIJChYXGBkaJSYnKCkqNDU2Nzg5\n" +
                "OkNERUZHSElKU1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6g4SFhoeIiYqSk5SVlpeYmZqio6Slpqeo\n" +
                "qaqys7S1tre4ubrCw8TFxsfIycrS09TV1tfY2drh4uPk5ebn6Onq8fLz9PX29/j5+gEAAwEBAQEB\n" +
                "AQEBAQAAAAAAAAECAwQFBgcICQoLEQACAQIEBAMEBwUEBAABAncAAQIDEQQFITEGEkFRB2FxEyIy\n" +
                "gQgUQpGhscEJIzNS8BVictEKFiQ04SXxFxgZGiYnKCkqNTY3ODk6Q0RFRkdISUpTVFVWV1hZWmNk\n" +
                "ZWZnaGlqc3R1dnd4eXqCg4SFhoeIiYqSk5SVlpeYmZqio6Slpqeoqaqys7S1tre4ubrCw8TFxsfI\n" +
                "ycrS09TV1tfY2dri4+Tl5ufo6ery8/T19vf4+fr/3QAEAA3/2gAMAwEAAhEDEQA/APF/gv8AtGfE\n" +
                "H9nXxJAvgvVxd6W83n3/AIUvbkfZ7tBgOU4Jt5CGGJUH3lXcHUFT93/AH4+/Dj9pLwg/ibwFdSR3\n" +
                "NlIsOsaNeYW6sJTkqJFHDKwB2SLlWAIyGVlX8gPg5ptwNcfxRI0hgjDLbCQ581iMEjPYD9foa9W+\n" +
                "Dnxf8bfAf4s6d8XvAkryT2MwW/08TmOPUrNiPNtZDhhtcDIJVtjqjgZUGvyXJc4xGTYqOHrVOaH5\n" +
                "HlUZuDs2frD9lKuVYdDyNuKljg9Dgd81S8A+NfC3xX8C6V8TfA16bnStaslubRyyl0BGGicKWAkj\n" +
                "YMjrk7XRh2rWjjK5TZk+9frFKrCrBSjrc74tCQoVHysePQfzq1EhAxv4xyAaSOMFRkd/79WY4eOF\n" +
                "H4VbXcoI4xxuI+hNXLSE5DAADPU1HFESwIXnPsKu2UDE7Sm36n/CkBPZxEHpx6Bqvxou337VBbqW\n" +
                "P44OKvRIB9e9Jq4CxJz92rUKECoo4+ckfrVlIwO1Syye3jB7irKx5FMtkH9361ZWMmnYNbjBHn/9\n" +
                "VKIv9mpVjpwj9TRogIPKOOlO8vtxUoSl2juKWtw6kOwikK+oqfYOwpCnpTswIdme1L5eBmpdnqKX\n" +
                "YM9KVybshKZHNGw46fhUxj9qTy/51W4+hD5f+zR5Z/u1PsHpSbBTFdn/0Pi2GKGwiS1skEccSBY0\n" +
                "UcADpWt4ft0MPktj5pMlvQYqjbWjy7pT0V9pOOK1tHh2KSBzur+csZXk1zdTwHdbHu/7En7Req/s\n" +
                "5eNXsPEN1PL4L1q4H9tWqKzixmxtW+jQc5AAEiqMugHDFEFfonbmy1G1i1jSr2C4tbuBZba5tpQ8\n" +
                "csbAMrqwyGUjBBHBBr8svDlrFJGbUgEMQc4PevsX/gnv8a7vUrK5/Z+8V6g0k+m27XXhyaaQfNag\n" +
                "jzLYE4LFCd6j5jsLjhYwK+v4F4nq/WPqOIf+F/odtCqn7rPpCMZO/cOpyTU8YU8KM89lpwiEbbW/\n" +
                "E+tTQpnqueeeK/YVZ6nbfQSOI52j0wOM81etogMNsOcAjj9aihi2jP4CrdquGwOOc4xxSaGWbdBn\n" +
                "jjnvV2ONePpUNvEMDnPHWrca9h35qQFjj5yP5VZjSo4o8kZFWYk7ZpFak9suenQ1ZWP2qO3izzVp\n" +
                "YwO1MdxgQjjFKFGelSCMUuwelJgthgUdhSeWDztqULjjFKEPpTCxFsOf/r0FQTUuw0bDQMi2Y/ho\n" +
                "2YPSptnvSbTSEyL2NIcdTTpXVBk8epr5t/bZ/wCCgXg/9lrRri006O11LWoowZLWafalvuGVMmOe\n" +
                "RztznBGM9pnUhTjeTsRqfRb3MKtguB9TSfa4P76/n/8AWr8QPiR/wV5/aY8W+K59Yg+K+pWMTfLF\n" +
                "aaNILS3jXJICooJPX7zEse54FYP/AA9T/ac/6Lb4n/8ABu3+FYfWo/yv7gsz/9H5X0bTbJfA2ryS\n" +
                "AefDdQSQnH8LHH9ak0uAxDaMc85I71pw+Fdf0/QrwX1qiqbOOaTa2SULLg+/PHHSoTataSGOQ4wA\n" +
                "M49q/m/GwkkkeBNJSOg8Jq/ktM3ZsD6Cuq8NeOdf+GPjTSfiX4WfF/o14txGrMwWVRw8TbSCUdSy\n" +
                "MARkMa5TQFMEIQkZIyea2yPOhETsOQQMHPavLpyqYbFQqweqaJi2ppn6h6DrOleL/Dum+L9Blkaw\n" +
                "1jT4b2wMke1jDLGsiEg9DtYZq/HDwCwBB7A9Pzryb9ga/u9Y/Y28E3N/dSTPBNq1mJZHLN5cGrXs\n" +
                "aDJ7KiqoHYKBXr0UPH3AB6Gv6ay+s8RgoVOrSPZg7oI4gD07elXbWEH8O+Kiji6YXmrdqhXnYK7j\n" +
                "QswKMCrUYGMmsLxd418M/D/w5eeLPF+sw2GnWELTXd3M3yxoB7csT0CgEk4ABJr8/wD9qv8A4LY2\n" +
                "/h6/vPDPwkih0yKL5Evr6ET3sp/vLCCUhHpv3HGCQp4HHicVQwkeao/l1foibu9kfpCJ4I1Lu4AA\n" +
                "JJJ6CuA8fftg/sz/AAqUHxv8YdHtn3Y8m3la5kz/ALkAdv0r8QPiv/wUw+N/xOll/trxtrN7ExO2\n" +
                "3u74iEf9s1+WvI9V/aI+IOtyNv1cxq3VI0wB+ea4/r2Jq/wqX/gWn4alckr6s/fVf+Cnn7FVtGJr\n" +
                "j4tTJGTgSt4b1Db/AOiK6Lwz/wAFCf2MPFTLFpn7Q/h2Nm4Av7hrT8/PCYr+dJPiF4nkl3f23cgt\n" +
                "1xOw/TNbWj/E7xXb4H9quw/2gD+uK0U8zS1UX8n/AJlciP6YfC3xC8D+OLVr/wAGeLtM1eBcbp9M\n" +
                "v450GRkZKEgVsI6uMrX88v7P/wC2d8Q/hP4vs/EOl+JLi0ltn+S4tG2SqMfd44dT3VgQR1zX6sfs\n" +
                "L/8ABUfwD+0BLaeAviTeWukeI7iRIbC5DbLbU5G+6gzxDMTwEY7XYgIckJW1HEyk+WrHlf4P0/yD\n" +
                "la2Z9iBSaXZRBIkyBlbrUoQA5rqC5Fs96NnrUu0elLigCHy/ekKYqcqD2qK5IiiaTIAC55pdNSbn\n" +
                "if7cn7UGk/ssfBm58Vi4gOtX+630G1nIIabbkysuQSiDk+5QH71fgH+0T+0T4l+K/i+8vLvXZ7qN\n" +
                "ruSQzzSFmuJGYl5mJ+8zEk5PODX0R/wWD/bE1T41fHW+0zSdbaXTbSIwabDG2EhtQx2cdQ0mDK2e\n" +
                "cOg6AAfDjylmyeSa5V+/lfoUvdRorqUmPmYsfWl/tJ/T9azxKccfzpfNP+TXUook/9Lz7xKtn4x+\n" +
                "Ef8AwtnSrZIbebw3AssUS8bmdNy9AMrJuBPtXD+MNKs9N1SztY5Sxkso5pARnr2/Suu8OeGNZ8I/\n" +
                "CLxt4M1K5LW0VvFLbwE8KVkBfHplQv5VwV1fza5qUmtXKLvm24x2UDCjP0A/Wv51xteFeUbdTw52\n" +
                "L1lMA4HzevP1rQm1BbW0a5kOBGpJJNZ1uFUFm4AFepfsq/st+I/2sPHR0wi5sfBej3C/8JZr0ajr\n" +
                "t3rYwZIDzyDg4yIlbewPyq14HK62Y4mNOmtxU4+0aR9p/sIeE9X8IfsX+AdF8Q26x3k9pe6k0auG\n" +
                "/dXuoXd5C2R6wzwtjqN2Dg5FesRw+3XOSKkaC0gijs7Cxht7eFBFBbwRBY4Y1G1UVRwFAAAA6AU+\n" +
                "NQo2Aj8K/oHC0Vh8NCn2R6qXKrCxxknkfmag17xBpHhXRLrXtd1CG0s7KB57q6nbakUagszE9gAC\n" +
                "fwq3tCjP518Kf8Fhf2qV8E+D0+DWh6jte7iF1rPlvg+UG/dQ8dS7gkjsEGeGqsRXjQoupLoJyd+V\n" +
                "dT5j/wCCkn/BSbxH8VvEs3hnwbLJb6XayH+zbNn/ANWP4Z5QOGlI+YL0TIB3YBr4M1fVdQ1S9k1D\n" +
                "Urt5ppXLySytlmY9SSeprY166vNYvpdQvZS8srl5GPqTmsW8iVeAAcV52Fw0qlT6xWXvP8F2R0pc\n" +
                "qKMk21SM5qEXOG5H60+5yD04qs6ZbKmvS0QMuw6kYwu1RgHIrX0y/wB4VWHPf2rnY42HOKnhnljk\n" +
                "xtOB3qrtAdbBMA29GrqPBvxG17wjeLPaOJI/44ZPusK86stYdCAzHA7Hmui069huyqohyTjA+lZz\n" +
                "pQqwaaEpcrP2v/4JA/8ABRDUf2i9Fm+CXxV1Uz+I9LtfO0XUrmXMuo2qYDxSE/fni3Kd33pIzubL\n" +
                "I7t93J8341/N3+y18aPFnwD+LuifEjwbdeXfaXqEV1bqXKrIVJzE2CDskRnjYd1c1/RH8IviNoHx\n" +
                "b+HGh/EvwtKz6drulw31p5mN6pIgYKwBIDLkqRngg1GHclenJ7fkE1bU6TaB0pcUoXPSl2D1roIG\n" +
                "4FeeftWeP0+Fn7OnjHx4bjyWsNBn8mUdUldfLRvwZhXopQ9q+SP+C1vi/UPB/wCw5qn2C5MY1HV7\n" +
                "e0nAP308uWTb+can8Kzqvlgws2z8HvjRq6a/8Q9T1QSFkaYRx5OflRQg/wDQa4iXG7CnFb+tsbud\n" +
                "7hs7nJJ+prAu18uXGDWdGPu2KkrMVQG5L/5/Kl2r/f8A8/lUBkb/APWKPMb1/St7En//0/MpvEfi\n" +
                "S+0+/wBK1K/gnjv7R7eaRrZEfa3cFQBnHqD1PHSuXPhDU9Ns/Ns4hJEvCZYDJ9MsQB9TitzOHykS\n" +
                "KO3FPCB4/JkY7f7qseDX8sRxE6VRSetj5+9j3z4Gf8EmPjH8QfDth8Sfjj4y0rw94Uvmf7JaeE9a\n" +
                "ttUvr5RjDLc25ltIUYHIYPK/y42DOR9r+E/C3hf4deENN+HPgLw3BpGiaNbmDTdNtVISFSSWbJJZ\n" +
                "3diWeRiWdmLMSSTX5j/Dfxr8RPg7q8niH4R+PdU0G5uNpuRZSfuLraG2CeFgY5wN7EB1bBbPBr61\n" +
                "+A3/AAUP8JeLZIfC3x7tbTw5qb7Uh161R/7OunaTYBIDuNocMpLOxi+V2LRgBT+vcKcQ5HK1GK5Z\n" +
                "+fX5/odlGpCKPpDaGYZH40+NMdfzos2stRsLfVtJvIrqzu4EmtLu2mWSKeJlDK6OpKupBBDA4IOa\n" +
                "mROeOc1+kwqQqK8WdqakiK4ytuzZ7V+GH/BTz4h6l4x/aO8QXF3dF44/EGoWka54At7hol4/3Nv5\n" +
                "V+52qI50+UJ12nH5V+BP/BSDw/qHhf8Aa38b6Fd7gq+Jry6iU9Atw/nqfxV1rgzPSNNPbmVxwSdY\n" +
                "8OkuQyn3rPuUEhxtHFSuzDgCm20b3NysQH3j+VdV7RN7XZWbSGlXfzyewoi0XL7ffrius/sCSPT/\n" +
                "ALQEO1B6VnRxYl6d6lVI7GroyRnyaJBFDvx9OBWZc2qhjjrntW/qchCbBnjpVHTvD2r61N5Wm2Es\n" +
                "x3AHYmeT0o9okrsaoznK0UZf2bL++fXFa+gLPDMGVSBkd+K6/wAN/s9eO9VlDX2i3FtHn5nkQDj2\n" +
                "yea6u7+CkPhzTTcSR8qMlzk//WrneKhf3Tp+oTiry0Oa8P3hjZLtiAYmUj68Gv2n/wCCIP7ROkfE\n" +
                "j9mx/g/cXyf2n4Pu3MMDMNz2Vw7SI47nbKZkP935M/eFfjE+hwwW7z28isQeoBr6b/4I5/FTxZ4F\n" +
                "/bd8I6DoMknl67PLYX0QYhZLZ4maRWA6gFI5AOzRKfYlXEKnKNR+j+Zg6D5Wj94kXI4pdpplm5eI\n" +
                "EnsKmwa72cbVhhUiviP/AIL4W80v7D0VzEflg8XW7Se4azu4/wCbivt+vjf/AILhyaZffsUy+GJ3\n" +
                "zdaj4psIbMDs+JpCT6DZHIK58S0qQ4K8rH4J6mvl8FT+VYV4p3evPrXRauFfnIrn7tQHO3B561VJ\n" +
                "twRU0+ZlQrzyDRsHoac2c9SPpSZP99q2MrH/1PH45cjcJw3Oeau2rl8CNc+mO9eq/GX/AIJ6ftFf\n" +
                "CBZNS8FRL4+0VQCbrQLQx6jFxGD5lizMz5d2A8h5flQswTpXjGk65BdgSHy5SG2sCSpB9D3U+xr+\n" +
                "dMzyDFZdK1WDS79Dwp0pQ3R0IeRoM+Q5IxkE9qdCsLZ8yYZYn5PLP9arQSkEOlkqgjnbJ0/yKvo7\n" +
                "OmfLYntzxXz7pRpvmi9SLtaHcfAn48fEP9nrWEuvBV+Z9HkuPN1Hw7cSn7LdZAVmA58mTaq4kQZy\n" +
                "ihgygqfuT4JftB/Dn486IL/wnfGHUIo92oaLdkC5tTnBJA4dOmJFyPmAO1sqPzpxHgbZirHjGasa\n" +
                "B4q8UeAvEFr4z8G6xNY6nYSCS2u7dvmU4wQQchlIyGQ5VgSCCCa+z4Z4yrZdVVDESvD8v67HRSru\n" +
                "EknsfqHdIGt2BPUGvxL/AOC0Oj2tl+2RrclpGN8tpZSXBA/iNsqjP4Ktfrr+zP8AH7Rv2jfhkPEV\n" +
                "uLeDWbLbDr+mwt/x7zFeHVSSwik5KE56MuSUavg//gpX+zfY+N/2iNU8S3Kq51PT7V5AzFWG2Mw4\n" +
                "Bx/0yz17mv13MMbSr5dGtTd03F/ij1sNSlXxEVHqflw8eTzXV/B74c3XjbWi/lt9nt8GVh3J6Cu3\n" +
                "+MX7K+reB4v7U0CaW5t+TJFKo3xAd8jhh+RHvyRe/ZR0XxhDFcjS7Ulgy5R4+vB9RxUPMIVKejse\n" +
                "/Sy6dOtaSuW/HPw2/srwwLOwtC8rk7VXknGOBjNefD4QfEm4jMln4MvgP78kDIP/AB4c19R3o8Ya\n" +
                "en2zXfCmVQZ3oysB78ZxRF8Y9IglOlDw8sDcgSvGCeB1Iz1rhjive0nY754WnbY+UB8E/il5nnTe\n" +
                "HpCmRkeS/wD8TivVPhML/wAOQRadrHh0R+UuGbGO+c4xz3/M13fjb4o2tvHtVGO7PyhR+Vc1omtf\n" +
                "20xuEZlIIyCORxWzxVWOilcmNCEHeKO7vdVsUsfOjtyMqSAOP0ryLx5oHxG+IOsR2enT2tvaB25C\n" +
                "ndt46/l0HXvXR+L/AIh3OkR+RbacWVY8mYngfh2/WsWPxX4gIWazJ3MRnjA57VlH2kpavbsVKMZd\n" +
                "LlnS/wBnS9s9OJvdXkI2naVULk89ueM/Sv0I/wCCL37EXgvR7i6/aO191u9UtpXsNDhUnZagr+9l\n" +
                "fs0jKQFHRVYnliNnxh8OIfEPiCe303U+WmIHyEjgDk/lX6U/8Ewfhr468Fz61eLryJpEhhjms2ty\n" +
                "3mygOdytvGwruXJ2nIOOMV6eFanOLcW1seXjYqMbLQ+0raFUTAHFS45oRCVyafsFey9zxVqRlRiv\n" +
                "hD/gulfTad8A9AmjPB8XQH8RaXuK+8WXHNfBf/Bd5Wl+A/he3/gPjCIt9Ra3WP5mvHzmUo4R2dn/\n" +
                "AMFHoZZSVXEqLR+JOqaPcROySRHI659a57U7Z4icjivc9a8J2t7E5SMZwa8j8UWRs5ni29G9K1wm\n" +
                "Ic6cTTH4X2FRo5R3IbgZpPMb+7U0kCl+QKT7On+cV6HvHmWR/9X9DbeR4SrA8g5HOK81/aF/ZC+E\n" +
                "X7SUb6trlp/YviXBMfifS4EE0rCIIi3K4AukXbHgEhwEAV1BION+19+0n8R/2W7fRviRYfCq38S+\n" +
                "DJHNr4ge2eSK506Zz+5laXcyLG5PljdEBv2qZFMigz/C/wDb8/ZT+JxihTx7L4YvJWfZY+LYBZ4V\n" +
                "RncZwz24z2BlBJGMcjPi43HZRUrPCYlpSfR21OOTi9GfFfxw/Z7+LX7N2tLp3j/R92nTSKthr9ir\n" +
                "PYXZYMQiyMo2SfK+Ynw3ykgFSrHm9PuZbmHdbyRMc8o7BSK/Vi70vw/408Lmy1TTtO1vQ9Vt0YxT\n" +
                "xx3VpeRHDKcEFJFPBHXsRXxp+0l/wTY17wj9q8d/s3tdarpqmWe48KXEm+9tUHzBbZzzdKBuAjb9\n" +
                "7hVAMrMa/O+IOClOm6+Ad12/y/r7zmnQvrE+fPNUt5U0BBHVlcEUkMiMSiNgHtWVY63Ebh7G7Bt5\n" +
                "0JR0lXGGHUH+6frV9t0mXjUBsZBQcCvyTEYOvhqjjPRo5Wmnqdj8AvjZ4g/Zs+LVn8R9Jh87TpgL\n" +
                "XxDp4jD/AGqzZwZEUEjEgwHRgRh1AOVZlPvH7eWm+GvEfg3TPj/4F1NNQ03V7aNLC4iQhZI2SWVW\n" +
                "IIBU54KsAQTggEYr5hW38+z2T7WDx4YY9e1e1/sXXt/8Vfhb4x/ZP8RvJOkVs2ueF2lbKwbZFFxC\n" +
                "CznapZ45FVFAy07E5Ir9D4Pziti8JPLar2V4nsZRiXTxKR80G7HjDTrmyuIg+5SrgDscjP5VY/Zv\n" +
                "+FMfhm8aNoURVlMhWNcB3IAB+gCjpjmu6tfgk/grxBeabLC4bzikiyLg5BP5V2vhjwzb6WoEVsFP\n" +
                "dscmvpaGIquhFS+Jbn6hGFOpFTj1M3xJ4MtNUt2h+z7SVypHUGvCvHHw1/snxAJZrUBDICHUdR0r\n" +
                "63ttItriEKyBjjFch8Sfh5p15bmbCp6ADvXXQcpP3mKVOKPmDWPBFnqEKxSopB7FBx+NUp/BGl6X\n" +
                "Yxwac43HqMfr616B4o8Mw6bcMqXK4Un16VH4D8Kwa/riREgKhyxNes66TWl2c6w/Mct/wzrN4o8I\n" +
                "y3E8TvKwDRqi4x19ufzrF0P4cx6XG9pqcIRSxG3ruUcc/l719bh/BPhrSxC17DKyIQEZlJxzxgV4\n" +
                "d8UrrR73xJJeWc2Fcg7FbphcGqhUSbl16mdSlGNkit4JXQNGv1vY03yqpEZAI2gjB9q/Uz9gYx6r\n" +
                "8CtL1/y9sl4JZJMDq32iZT/6CBX5UadqVlawDGM4JyT7Gv1q/YP8PXegfs1+F47v/l60yK9hI/55\n" +
                "3Ci4A/OVq9LAVr4hU/meRmlKMcO31PaVQjijac0/Aor3NT5e1iMjsa+S/wDgsB8DvFPxh/ZUub3w\n" +
                "ZYvdX/hjVItaa0hXMk8EUU0cqqO5VJmkwOSIiACSBX1uwyKp6nYrdwtG4+mO1cOYYT63hnA7cHX+\n" +
                "rV1PsfziaHDf6nfNZx27NuB2kDj656V5d8T9Gey1WUmMjLngjoe4r9Nf28f2ZtC+E/x0vNS8OaLH\n" +
                "a2OuB7yGGKMKsUu8rKqjsCcSY7eYQOBXwz+0h8O7yy1WTUbW2LQzNvYqPuMev5nn8a8DB1XSkqcn\n" +
                "drQ9/HWxMVVS3Pnd7QlshP0pPsjf3P0/+vXTN4bmLHdAB/wGk/4RqT/niP8Avn/61fQLEwseC8M7\n" +
                "n//W+/PHHw8sPi78Ntf+E+rfZ1h8RaFdacs11bLMsEksTJFNsPUpIUcdCCgIIIBr8k9Nt5Z7EWOt\n" +
                "ae0N5bu0N3BPEVdJFJDKynkEEEY68Gv2Gs2MZDpxivz5/wCCj/7O998HPi5N8bvDyKfDXjjUmkuf\n" +
                "K37tP1Vl3zI5YtlZ2EkyEEAEyptUIpb8s8T8lrYrCQxlBa097dn/AME8+pFrY8T8D/GL4tfAfW21\n" +
                "r4MfEfUvD08rj7Tb2koa2uTtZV863cGKYKHbG9G2k5GDzX2R+zf/AMFR7DxBNH4a/aP8PW2jXbHF\n" +
                "v4k0SGQ2r/KcCeElnibKj503KS/KoFJr4RktfOv/ALZKS5b5vnXoa27Z0iYFQB7Gvgsg4rx+UyjT\n" +
                "nUcovo9TJVXA/TH4/fsgfAn9q/TI/F10403W7q1WWw8ZeH/LdrpDDthM6/cvIceWQcq+2NQsqjIP\n" +
                "wv8AHL9mT9oT9lia4v8Ax/4YbUvDETDyPGGiZmsNpMSr5x+9ZsXlRAs4UM+QjSAZre/Zz/a1+JH7\n" +
                "PTrDot3/AGpoMkgN34cv5j5Q+bcXgbk27nLZIBUk5ZWwMfoZ8HvjB4N+MPgq0+Jfww14z2U5Mcqk\n" +
                "bZrOdQC9tOmTskXIyvIYFWUsjKx/T1hsh4uo81kqn4/8H+tjaPsq8T8qdF8TaddqkskuIZMEMFzg\n" +
                "d69m/YPs7Vv25vAd5Fh4ltNbMig8MP7GvsfXnbX0F8f/APgmZ8Cviik/iH4Qxp8O/ETJlV0e2zo9\n" +
                "24VABLZjAhyExvtymNzMUkPX5Ov9O+N//BP/AONnhzxp8TvC4t5tMvJJbS906ZJrTV7TLw3KQSlS\n" +
                "AZIWddjqsqCVGKKStfMUuFMZkGdU8Rbmp33XReaHCh7OopI+mP2vfhjdeH9VPjfSLAvbyuUuwg+4\n" +
                "R91z7EcfhXkul3XnW6uUKnHIPavuk/8ACLfFDwdZeJ9Av0vdK1nTorvT7yIECe3mQOjrkA4ZGB6D\n" +
                "rXyL8ZvC+neCfFdxptmVWPeXjULgBSzYHHsK+xznLI4eP1im9JdOz3Ps8nzKTfspPU5aXVpLbpIR\n" +
                "gVxPj/4juqNaxTAtnLHHQ/hzW1qd19oVkicenBrhte8PF5HkPBbnj39+1fP0ZzR9NJpnnHivVr6/\n" +
                "uuWYgnJP41JpUc9pCXD4z3z1p3i20lt5vJt4iXzkAL3+uKzrbV9YjiCXkBQE/fx9f89e1etSlzyt\n" +
                "Ii7S0KPiPxP4htmbT7KQxJ/Eyv1+lYKy3Ea+dMxJY85Pep/FOpREm4t7pmcjGwoRkjtn/PT3rEtZ\n" +
                "Nak3TXeQmeFIBx+P+etdMKLgm2c05uWp2vwv8Ha38WfiXoPwz0R2W41vVIbRZApbyldwGkIHZV3M\n" +
                "fZTX7meAPDmm+FfC9h4b0i2ENpp9nFbWkI/gijQIi/gABX5of8Ecf2d7zx58W7/466zZN/ZnhaM2\n" +
                "2nyMpAlv5kwcHodkJbI/6bIa/Uq0hEaAdgOK9rJKDcpV5eiPm85xHM1TXzJAnrS7RS4oJAGSa948\n" +
                "C40p6Ux0JGCKhv8AVrWwTfNIB7ZrA1H4reEtMj8281WBRnHEwb+WaTlGO7KTufP3/BSn4NXHi34e\n" +
                "W3j7SbffLodwWu1C5YwPhWYf7p2k+2fSvzr+IHwyj8SWkmnXdj5qORn5tvQgjnr2r9Rvj58ZfCXi\n" +
                "z4d6z4U0syzNe2TRCUR4UE9OpB/Svi7XvhZPcTP/AGfKgyTtWTIwPwzXxWZ4etTxLnR1R9ZlVenO\n" +
                "jy1HY+UP+GbdBhHl/wBnLx/ek3H88Uf8M5aD/wBA9Pz/APsa+hL34U+LorgpHpUcg7MtygH6sDUP\n" +
                "/CrfGX/QEX/wLj/+Krz/AKzjP5ZHscmB8j//1/0XhB4H8hVLxv4D8KfFLwPqvw38d6aLzSNas2tr\n" +
                "2AqCQDyroWBCyIwV0bqrqpGCK0o0wPu/UE1Ioqq1KFam4yV0zma5j8h/iz8KvEXwM+KWvfCHxPdG\n" +
                "e58P3/kxXgVVF5bMoe3uQFZwnmRMjFNxKk7Scg1kxH5QGYnHvX3b/wAFHfgZZeNb7w78UcCOVbGf\n" +
                "Rb+4ec8Ab7i2IXOBtb7Rk99yj0r4TNrPaB7aZQXjcqSvQ49K/mDjLJXlGaTjTVot3XzPPqqxasZp\n" +
                "ldVViM8cmvZP2J/2kv8Ahm340Qw+J75Y/B3il47PxIzRqRZtllt7wEsu0Ru+H5OYnf5WZUx4zZRz\n" +
                "CNXK/lzVzUNOF7Z+S65V0IbI6joR+VeTkWdYnKcdCpGXXXzXYzp1JQmmfsRcWz20zQyoVKNggHvW\n" +
                "P8QPh/4L+LHgm++HfxG8OWusaJqcJjvdPvUyjjsQQQyODgq6kOrAMpBANeY/sCfFe8+LP7Leh3es\n" +
                "3stzqfhyeXQNUuZY8eY1sEMLZyS5NtLbgseSwY+9eneKPG+heFbNrrUrxEwOFJ5Nf1XgqkMxwsKk\n" +
                "FdSSZ6cq1OlHmk7I8Y8GeH4v2Df2bNS8Eaj42N9ouj61fv4WNwgM1lp9xcB4LaR2x5zo8kg3ng7g\n" +
                "OAvHzf4u+IV98Q72TxDc3PmGYAqV5G0DAAx7VF/wUv8A2ptI8YWdj8O/D2plit08uoRxt93YMIM9\n" +
                "DyWPHda5n4VxQ3PgXT7tm+aSyic59TGpryOI1Uo2oPRWuerw3Knjqsq0XfW3+ZS1HXJrWUozHhiK\n" +
                "zrzWpbgbCQT0JHTNXfHlgYpTNGBwTnArhh4gayuvKnyAM5+XuPwr4ZNo+98joU8O/bZVmeHPXGfX\n" +
                "GKzvFmlW9raSKsYHykLtXjOCB/n3rb0DxlpE1qIzcKCVxycVB4n1TQLi1bzL2D0C7+c8ntXdRnLo\n" +
                "U5RseJaxZ3Ul8y/w7vu7u2ep967D4OfBLxH8Y/HWk/Dbw8Fjn1O7VHuJR8sEYGXlbpkKoJxnJOAO\n" +
                "SKp6vrOh21wxLKWDdV5Ga6D4R/tFp8I/Hdtq9ghEicEJcFC6ZGQcA5GQOPavfwOHqYurGlffQ8rM\n" +
                "MUqFJzS2P2F/Z2+Cvgz4BfCzSfhl4JtPLstPgw0rAeZcSnmSaQjq7sST2HAGAAB35kjhTcWAA6mv\n" +
                "hX4C/t5+N/G8kVh4Y0K5uwEG5J0+VB8uMYOcYPU7QMV9D2Xxg8S6zpxTU7eOJ9p/1RPX8RX3WIy+\n" +
                "OAiqcNkfn8MZPFzcmtz0yfx94Whne0/tiB5UJDRRzKWBHYgHPasfWPiXEpMVgoHq7/4V82a/da9p\n" +
                "vjm71WS4PkXMu5QecDcx4z04NdfF4gaSyGLjeSB81cMeZ9DpsjpPG3ji7ug0aXOS3V89K8+v4JZ4\n" +
                "yN3UUeJNUdcIr5Jzk0aTfR3sI3dRx1zWfsYSm1I1jdLQ57XNAluoSu4+wHFc1N4euY2K+QTzXp09\n" +
                "qjKeKz59MjmOTFke4rVYWKRcK84KyPN20WQH5osH3zSf2K39z+dehnw5bk5EQ/L/AOtR/wAI3B/z\n" +
                "xH5f/Wo+rQ7FfW59z//Q/Qb4a/EHwl8WvBFh8QPBF601hfoSqyrtlgkU4eKRf4XU5BwSD1BIIJ3Q\n" +
                "AK+JP+CaXxjXRfjHf/AmPWFvtN8T2zXekiCUyot7DCZsph9ih7dZQzAEsYYhkYr7iks5oXKywOmD\n" +
                "g5U/1rxuHc2WcZZCvaze68+pgzm/iv8AD2D4sfC7X/hvLNHDJrGkz21pcTAlbe4ZD5Upxz8r7W49\n" +
                "K/KfxBo2tabbXEWuaY1pqGlak+na1ayYDwTqWBDDthgy/hiv16AI468V8cf8FNP2fG0wT/tG+EbR\n" +
                "vs2owpZ+MLdWcgSgBba8AwVUfKsTnKjPlkAl3avlPEHIZZhgfrNJe9D8jmrQVrnx/YEq5Jzj+HNb\n" +
                "NuiyRHDZx61zujXzXMUUisMsO3PtXV2CeVa7S3Ud+5r+fFQlOsor4nsedWny6s+hP2JfjnbfCD4P\n" +
                "+PNL8QavFZ6fDr1lqNqdnzF5LeSGfBHX/j3t+PU+9eR/tBftyeIPiPey6P4VWSw05WO+eZ/39x9c\n" +
                "HCL7DJPc9q8f8b/FSxnjn8L6Jdggv+8lRshuh4x7/qtcFLPJz5kxYnuTzX9+eHvDMKPD2G9trJRV\n" +
                "z834kzzGe1dKF1Eg+JHiO+1nV/ts90z7sKMt0AHb2zX0F8JvFUx8OxWayDy4kVYvYAAY/QV816+U\n" +
                "nhUnkq2a9n+Ddwtz4XWWB87ZWX+VfMeJ2WuhilKC0cV+Df8Amfp/hbiubAcsnrd/oeg63rYu0Ksz\n" +
                "EY5ya4TxPDDcR745MMBznuK6DVWeNGwMjHOK5HX9Sdg0Ck9M8djnNfj0Yq2p+wO3Q4zW7zUNPkLW\n" +
                "8zbR/dOK5vWPF2ts237Q2AuAAx5+tdRqlvHcMSfyz0rndS0iESZA4I547V10YJaI56kpbIq+FXvN\n" +
                "X1VV1NwYywOPavQLz9l74p/HXU7HT/g74XuNQnijY300c4iigGAU8yR2VFyd2BnJxjnFT/sqfs+6\n" +
                "98f/AIsWngnR3a1s4lNzrGoqB/otspAZgD952YqijnlgSNoYj9UPh18MfBXws8LweFPBuhxWNpDg\n" +
                "7EXLSvgAyOx5dzgZY89B0r6jKcJVqXntHueLmGIhCPK9zjP2Y/2d9L/Z/wDhdp/gqL7PNewWsaaj\n" +
                "fwRlftUirt38889ce5+tdzPfJBIVxWpLcKilYx2rmtbhZcyIcelfU1a05ve58vypSbHaitrqCbXA\n" +
                "z2OeaxJIL7TyTbybl96j/tt4ZAkpOPfJq/Z3MN4MF1P1NZxnzbFpNHMa3qc1y7NOx+mKj8N+KorT\n" +
                "UBbST/e4611Op6FpmpQmOeIZI4ZeCK838cfCnxhYzf2v4SvFnVTkwSyBW69iQBj8amd4yvY0i0eq\n" +
                "x3ccyB1OQRnNRzNjv+Rrk/Cusarb6XHFrJ/fDIbp6n0JHTFbTapC67vMH0zXTGV9SJJ3uXftrLwM\n" +
                "H68Ufb3/ALo/Os/7fAODKue/NH9oW/8Az0X86LMyfLc//9HhtY+J2l6/8X7H4s3nww0e7tbDULe4\n" +
                "Ph3UITJa3ccLKRFMON4fDBs8HcQcjiv0o+CPgP8AZug0Gy+MX7PHhK40nTvFGkpOlsNevJoo1dld\n" +
                "4jbvcywRSRyK0ZEajYUZQQCQfyktr5sCJWJUHnNfon/wS88XzeK/2Q4bCWGNF8O+M9W0i2KdXi/c\n" +
                "XmW9w97IPoBX5xwPiFRrTwq23OChU59D6EChRXj/AO338XdG+EH7JPjC91NRLca7pkmh6bbEndLP\n" +
                "do0R24ByVjMsmO4jI7167LOIVx1J6V8Z/Fr4wfAz4wftsR33xn+M+l+H/A3wUtftdhZ3ZnMms+IG\n" +
                "m8syRxwRtLKts6x/Iqk7omPMbMa+0zmrSjhvYzko8+l35irTT90+ftD/AGQ/jZ4W8NrrXjqz03QP\n" +
                "LZkjtb/UFmnfaMsQLUSoMZA5ccketeWftO+AP2sNB8FTQ6Z4HGh2Mm5J9Qub6AzyrvCbViLbkUk4\n" +
                "OQchhyBnP1945/b9/Z28Ma1dXvwh+F+reKNSluSJfEGrOthEyqpWN4VKySYwSCCsTHGSSa+cPjB8\n" +
                "V9X+Ot4L3x14S0WVlbMKpFKfL+UDgtIfTPuSTjmvhMLT4B4frqrN+0nHXvr+SPOrw9otEfIvjv4O\n" +
                "fEL4X+GE8V2fiVtRjVwbwm2EPk7ioXKh2BGTtOORwe+Rxln+09caawtL/azrwxNypB+gPI/OvsW7\n" +
                "tdR1Sxk0m7e2NlMCJbUWcZDDkYJxkjBPB9amt9ObTrf9xezqo/hjO0D9a+kfjTlWBsqEJPyWn+Zw\n" +
                "1Mtw1W/PE+R4P2lfDN8AuoyeT33qjMO3GFB969s/Zr/aN8A3Nt/Yb+IIV8ybMSzK8ZJOARllAJ6c\n" +
                "Zyc16fZx3V6u8Ty4z1Mh5q1HYqMjzGx3O414XEHjRgc1pKE6DbXmj0clp0cok3TVrm/ezWuq2Yu7\n" +
                "ScOrrkHd1GK5m40G2urlpbqdimfuqRV2HS4pJR5TO7Z6tWL8X/HehfCHw3baxq8e5bm6+zou4jLb\n" +
                "HfOQp7Ie1fnj4xjmWOp4fDU+WUnr10Pro5/WqNU4K1+pzmqwG2ZkX+E4rFeNrhyF7Hniqf8Aw0d4\n" +
                "Bu1+0NZ20h67Pt7Z/IoKj8I/GSH4rfEPSvht4N0GGO41e5S3g+ZWPmOwVeQOgyc59R6V+l4fD1ox\n" +
                "XN1PpViIuKW5+jP/AATY+EP/AArz4OnxXfWYS/8AE0y3kjEDcLZRiBSc8jBeQf8AXbB6V9FXN4Ml\n" +
                "QMDoKwfB1vaeHdCjsLRFSKGPZEi9lHAH5DFWDehs5bnuTX31CksNSjSPk8ZV9viG0XzKG5NQ3Nqt\n" +
                "wuGHB60yKYEZZvzNNu9TEEeAMH1rpTSOWWmhk6r4dt5H8xFAI7gViXVnd2EhWFyfQitu+8QJ9wHm\n" +
                "su4llmO89OuKzlyiVymmvXkDASvke9bUOtWdxEIxMn9c1gTpbMCNnz9M5rMvEuYX8yGTP1p3dtdQ\n" +
                "sjo9TtLK7ckYB9VODWNf2V7BExtW3Ff4Q3X86ypPEl3aHEzc+wHNW7DxNHMvM3JPcYpqz2C7S0PH\n" +
                "/id+1Hpvw88RroeraXqJd7cSo0FurKVLMvUuO6ntXOf8Nv8Ahj/oE6v/AOAaf/HK+jvtdq3LhCe+\n" +
                "cUfarP8Aux/mKLVO5PLDqj//0vAdLn1GTTzd3NxEQUbAUYIOD1z9B+dfqF/wTp8A/wDCsP2B/DPi\n" +
                "/wAX6YNCg1BtT8S6xe6m/kxLFPdyCK4kd8KiG1ggYMTjbhuhr5z/AOCl/wCxivhOw/4aI+Enh2dN\n" +
                "ImnceNdM0myaT7EGVmOoJGoCrHgMJPmUBijD7zEcj/wUC/bjuf2otQs/gx8IJn8J/BTwfDb2OhaS\n" +
                "VaB9S8mNI43kjySwGwLFGfuqoZgHJA/KMDUp8JYqvPFO87Wil9peX69jzIRjSudN+1H/AMFRPEvj\n" +
                "W/uvCH7NcL6ToaNJDJ4purfF5fD7u6BG/wCPeMjJDMPN5U/u2BWvlL7KsUZefG7uBk565qVdOS40\n" +
                "06lGVSGNlWOIfwjpj37danS3LSbiDxzg1+e59nmYZvXcq07Loui9DJtXGpGkcH7wBQedp4rQsYcq\n" +
                "DuVMjjnt+NVXhaaTlDtBpzguvOWzwABzXzSfveZD3LysfMZo5ARu+ViO1MuY2lhw0v3uKapURBER\n" +
                "h6ZqH7Pf3+Y7VtoJ+96VzTpuN5S0RHNYcLxbdxb2kbHA+Xk8c1p2ei3tzDvvJmjBPCk/jzT9J8LS\n" +
                "wxF/tQZxjDYH41eTT717oW7XhfPUA8Zz6V4+MxdKKtAWrLek6Tb2shMbE4Q45r4u/wCCifxO/tX4\n" +
                "0W3w6s3/AHPhvTlFwjRYIubgLK3OfmHlC3x6EtX3bo3h2VI1DRsoc4JYc9MZx+VflV8dfFjeO/j3\n" +
                "4z8Y22uDU7S98T3jafeq25ZLVZWSDb/siJEC+wFfbeFWX/2hncsTNaRWnz0v8jpwivW9DL+2MR94\n" +
                "9Ohr7D/4IufDxfGX7SV742u4Emh8O6eAquM7JZt5Rx7jymH/AAKvi4SnH41+l3/BCbwibTwb4n8e\n" +
                "G22m81B7V5D/ABoiwGP8i0w/E1/Tn1en9agkvP8AU+kpVpqlK76H6KvqJtbcKW/WjT9ReZtzH86y\n" +
                "NTvBu57U7Srzdkjv/Ou+TbqHDFJK51Uc52j5uMccU/MUh+Y+1ZS3uF+8Bz1NOj1BV+bd+tUnYTSN\n" +
                "JrCym5MCk98qKJNKtJVKCIDI7ACqK6ttAUvn8amh1dH5L/mavQhmXqXhG8dz9kkXB6bzisq78Mar\n" +
                "ACZY1bj+E11w1AHkUjXEUgw6jFS4q+jKTZ53faN53yzW+D9Kyrzw1dW48yBuB/Cc16RfnT0jLOox\n" +
                "iuW1zWbCEFVI4603DuJytscBqOoa1DdNHJM49MEjioP7V1b/AJ7yf99GpNd8YWf9osF2kAdciqf/\n" +
                "AAmFr6L+YqeTzFdn/9P2n/gsl8TvFnhb4R+D/hXol2kOleK9RubjXAFO+4WyFvLDCTnAjMkodhjJ\n" +
                "MUfIAIb4M+FjHxf4wl1bXcSyWUEv2VMAJGSuCQPXHFfaX/BbP/kF/Cz/AH9b/wDRdlXxZ8Bv+Q5f\n" +
                "/wDXGT+VfiHHkpf27a/2V+bPJqHQ3AEGlQwRcK8xZh646VYHC4HcGoL7/jwt/wDfep+w/GvzWvrI\n" +
                "jqJAA0RYjnihVAcD3otv9T+X8qVfvj6/1FYozlsHmPJdhHbIOP6Vt6baW6TBQnBOMZrDT/j9X/Pp\n" +
                "XQ6f/r1/3xXm5hJuO5m9y9bQxiEkLg465rZ8IWVrDILlYVMjSYLsMkDA6VkW/wDqD9K3PC33E/66\n" +
                "/wBBXzUtVIr7Jy37Z/jzxF8NP2YfF3jLwndeRqMGmpDbXIZlaEzzRwGRCpBV1WQspzwwU4OMV+VF\n" +
                "nEkcQAr9Pv8Agod/yZz4y/697P8A9LrevzEt/wDV1/QvhDCCwbaXX/M6sD9oH+UYHriv1p/4I1Qx\n" +
                "237K1hNCu1p1kklx/E32++XP5Io/CvyWk6f8Cr9bP+COP/JqWlf9cZf/AE46jX7VH/e1/Xc9qH8N\n" +
                "n1ZfyP5pGelWdMLeW5DdKqX/APrm+tW9M/1Un4V1dSPsmkssmcbieR1PrTHmk2Y3dz/KlH3vxX+l\n" +
                "Rv8Ad/P+VD2M+pXnvrld22TvVjS7mZhy3aqNz/F+P86taV0H0H9af2gibcBOOvcCm3txJEjFcceo\n" +
                "pYP6iotS/wBW341qtyTmfE+r3qQMwkHTNeWeOvEurRwSOsw4GQMV6V4q/wCPZ/8Adrybx7/x6y/7\n" +
                "prOewHjfijx/r1vrMsa+S3uykn+dZ/8AwsbxB/dg/wC+D/jVTxf/AMh2X8Ky6yWwH//Z", "D:/b.jpg");
        Base64ImageUtils.Base64ToImage(str, "D:/c.jpg");

    }

    /**
     * 本地图片转换成base64字符串
     *
     * @param imgFile 图片本地路径
     * @return
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:40:46
     */
    public static String ImageToBase64ByLocal(String imgFile) {
        // 将图片文件转化为字节数组字符串，并对其进行Base64编码处理


        InputStream in = null;
        byte[] data = null;

        // 读取图片字节数组
        try {
            in = new FileInputStream(imgFile);

            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();

        return encoder.encode(data);// 返回Base64编码过的字节数组字符串
    }


    /**
     * 在线图片转换成base64字符串
     *
     * @param imgURL 图片线上路径
     * @return
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:43:18
     */
    public static String ImageToBase64ByOnline(String imgURL) {
        ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(imgURL);
            byte[] by = new byte[1024];
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 关闭流
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data.toByteArray());
    }


    /**
     * base64字符串转换成图片
     *
     * @param imgStr      base64字符串
     * @param imgFilePath 图片存放路径
     * @return
     * @author ZHANGJL
     * @dateTime 2018-02-23 14:42:17
     */
    public static boolean Base64ToImage(String imgStr, String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片

        if (StringUtil.isEmpty(imgStr)) // 图像数据为空
            return false;

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            // Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }

            File file = new File(imgFilePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


}
