package forest.ori.parrot.model.system.service;

import forest.ori.parrot.pojo.systemModel.baseUser;

public interface  baseUserService {
    baseUser findUserByAccount(String Account);
}
