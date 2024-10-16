package pl.edu.pjatk.MPR_spring.Service;

import org.springframework.stereotype.Component;
import pl.edu.pjatk.MPR_spring.model.Capybara;
import pl.edu.pjatk.MPR_spring.repository.CapybaraRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CapybaraService {
    private List<Capybara> capybaraList = new ArrayList<>();
    private CapybaraRepository repository ;

    public CapybaraService(CapybaraRepository repository) {
        this.repository = repository;
        this.repository.save(new Capybara("jakub", "brown"));
        this.repository.save(new Capybara("maks", "green"));
        this.repository.save(new Capybara("andrey", "black"));
    }
    public List<Capybara> getCapybaraByName(String name) {
        return repository.findByName(name);
    }
    public List<Capybara> getCapybaraByColor(String color) {
        return repository.findByColor(color);
    }


    public Iterable<Capybara> getCapybaraList() {
        return repository.findAll();
    }

    public Capybara saveCapybara(Capybara capybara) {
       return repository.save(capybara);
    }

    public Optional<Capybara> getCapybara(Long id) {
        return this.repository.findById(id);
    }

    public void delete(Integer id) {
        this.repository.deleteById(id);
    }


    public void update(String name, String color, Capybara newCapybara) {
        repository.findByName(name).stream().filter
                (c -> c.getColor().equals(color)).forEach(existing -> { existing.setName(newCapybara.getName());
            existing.setColor(newCapybara.getColor()); repository.save(existing);});
    }


}

