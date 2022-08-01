package com.project.sikdorock.service;

import com.project.sikdorock.dto.CouponDTO;
import com.project.sikdorock.dto.FoodDTO;
import com.project.sikdorock.dto.Paging;
import com.project.sikdorock.dto.UserLikeFoodDTO;
import com.project.sikdorock.repository.MyPageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MyPageService {

    private final MyPageDAO dao;

    public List<CouponDTO> couponList() {
        return dao.couponList();
    }

    public List<UserLikeFoodDTO> likeFoodList(Paging paging) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("start", paging.getOffset());
        params.put("end", paging.getOffset() + paging.getFetch() -1);

        return dao.likeFoodList(params);
    }

    public int delLikeFood(String fseq) {
        return dao.delLikeFood(fseq);
    }

    public int likeFoodCount() {
        return dao.likeFoodCount();
    }
}
