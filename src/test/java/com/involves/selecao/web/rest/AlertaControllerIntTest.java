package com.involves.selecao.web.rest;

import com.involves.selecao.SelecaoApplication;
import com.involves.selecao.service.BuscaAlertasService;
import com.involves.selecao.service.ProcessadorAlertas;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SelecaoApplication.class)
public class AlertaControllerIntTest {

    private MockMvc alertaControllerMockMvc;

    @Autowired
    private BuscaAlertasService buscaAlertasService;

    @Autowired
    private ProcessadorAlertas processador;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final AlertaController alertaController = new AlertaController(buscaAlertasService, processador);
        this.alertaControllerMockMvc = MockMvcBuilders.standaloneSetup(alertaController)
                .build();
    }

    @Test
    public void testEndPointResponse() throws Exception {
        alertaControllerMockMvc.perform(get("/alertas"))
                .andExpect(status().isOk());
    }
}
