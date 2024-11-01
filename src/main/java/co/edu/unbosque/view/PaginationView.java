package co.edu.unbosque.view;

import co.edu.unbosque.model.dto.CursoDTO;
import co.edu.unbosque.services.CursoService;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Named("paginationView")
@ViewScoped
public class PaginationView implements Serializable {
    private ArrayList<CursoDTO> cursos;

    //paginacion
    private int currentPage = 0;
    private int pageSize = 4;
    private int totalPages;
    @Inject
    private CursoService cursoService;

    @PostConstruct
    public void init() {
        cursos = (ArrayList<CursoDTO>) cursoService.getAllCursos();
        cursos.sort(Comparator.comparing(CursoDTO::getTituloCurso, String.CASE_INSENSITIVE_ORDER));

    }

    public PaginationView() {

    }

    public List<CursoDTO> getCursos() {
        int start = currentPage * pageSize;
        int end = (Math.min(start + pageSize, cursos.size()));
        return cursos.subList(start, end);
    }

    public int getTotalPages() {
        return (int) Math.ceil((double) cursos.size() / pageSize);
    }

    public void nextPage() {
        if (currentPage < getTotalPages() - 1) {
            currentPage++;

        }

    }

    public void prevPage() {
        if (currentPage > 0) {
            currentPage--;
        }

    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public List<Integer> getPageNumbers() {
        List<Integer> pages = new ArrayList<>();
        for (int i = 1; i <= getTotalPages(); i++) {
            pages.add(i);
        }
        return pages;
    }
}


