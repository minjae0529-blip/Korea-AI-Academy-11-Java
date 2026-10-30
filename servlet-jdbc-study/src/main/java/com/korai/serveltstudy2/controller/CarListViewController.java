    package com.korai.serveltstudy2.controller;

    import com.korai.serveltstudy2.model.repository.CarRepository;

    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;

    @WebServlet("/car/list")
    public class CarListViewController extends HttpServlet {
        private final CarRepository carRepository = CarRepository.getInstance();   // 공유 저장소 가져오기


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setAttribute("cars", carRepository.findByCarAll());   // 이 줄이 있어야 해요
            req.getRequestDispatcher("/WEB-INF/views/car-list.jsp").forward(req, resp);
        }


    }
