# Securing Connected Systems

### A Layered Security Framework for WSNs, IoT/CPS, and Virtualized Networks

[![DOI](https://zenodo.org/badge/DOI/10.5281/zenodo.20733453.svg)](https://doi.org/10.5281/zenodo.20733453)
[![Paper License: CC BY 4.0](https://img.shields.io/badge/Paper-CC%20BY%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by/4.0/)
[![Code License: MIT](https://img.shields.io/badge/Code-MIT-blue.svg)](LICENSE)

Companion repository for **Volume 1 of 10** in the **Engineering-to-Research Monograph Series** by **Alan Biju Palayil**.

> Connected systems, from a battery-powered sensor through an embedded network stack to the virtualized infrastructure that carries their traffic, are usually defended one layer at a time. This monograph treats them as three strata of one system, develops a unified threat taxonomy and a layered defense reference model, and grounds the argument in three of the author's own implementation studies.

---

## Contents

- [About this repository](#about-this-repository)
- [The monograph](#the-monograph)
- [Framework at a glance](#framework-at-a-glance)
- [Repository structure](#repository-structure)
- [Companion code](#companion-code)
- [Figures](#figures)
- [How to cite](#how-to-cite)
- [The Engineering-to-Research series](#the-engineering-to-research-series)
- [Versioning](#versioning)
- [License](#license)
- [Author](#author)
- [Acknowledgments](#acknowledgments)

---

## About this repository

This repository is the reproducible companion to the technical report *Securing Connected Systems: A Layered Security Framework for WSNs, IoT/CPS, and Virtualized Networks*. It holds the published paper, the source figures, and the coursework-derived code referenced in the paper's three implementation studies. The archival record of the paper lives on Zenodo with a permanent DOI; this repository is where the supporting artifacts and code live and evolve.

The paper is a synthesis and framework contribution rather than a report of new experiments. Its value is integrative: it connects three security domains that are normally studied apart, and it proposes a single model that spans them. See the [Framework at a glance](#framework-at-a-glance) section for the core ideas.

---

## The monograph

- **Title:** Securing Connected Systems: A Layered Security Framework for WSNs, IoT/CPS, and Virtualized Networks
- **Series:** Engineering-to-Research Monograph Series, Volume 1 of 10
- **Type:** Technical report / research monograph
- **Version:** 1.0 (June 2026)
- **DOI:** [10.5281/zenodo.20733453](https://doi.org/10.5281/zenodo.20733453) (version 1.0)
- **Paper:** [`paper/03_Monograph_1_Securing_Connected_Systems.pdf`](paper/03_Monograph_1_Securing_Connected_Systems.pdf)

**Abstract.** Connected systems, including wireless sensor networks (WSNs), Internet-of-Things (IoT) and cyber-physical systems (CPS), and the virtualized network infrastructure that carries their traffic, are usually studied as separate security domains. This separation hides the fact that they form a single layered attack surface. A compromised sensor node, a forged routing advertisement, and a hijacked virtual network function are different expressions of one underlying problem, which is securing computation and communication under severe resource, trust, and scale constraints. This report unifies the three domains. It develops a common threat taxonomy spanning the physical, network, and orchestration layers, reviews the cryptographic and protocol-level defenses available at each layer from classical public-key cryptography through lightweight and post-quantum schemes, and synthesizes the findings into a layered defense reference model. The analysis is grounded in three implementation studies that the author conducted, namely a from-scratch RSA cryptosystem, an NS-3 investigation of TCP behavior under congestion, and an encrypted microcontroller client and server link that culminated in the SensoryPi cyber-physical security system.

---

## Framework at a glance

**The system model.** Three nested strata of one connected system:

- **Stratum A, devices and the physical layer.** Sensors, microcontrollers, actuators, and gateways. Resource-constrained and physically accessible.
- **Stratum B, the network and routing layer.** Routing protocols, the embedded transport stack, and gateways.
- **Stratum C, the orchestration and virtualization layer.** The SDN controller, the NFV orchestrator, and the virtual security functions that defend the layers below.

**Design Principle 1 (Cross-Stratum Coordination).** Connected-system defenses must coordinate across the device, network, and orchestration strata, because attacks propagate across those strata. A control that is optimal within one stratum but uncoordinated with the others leaves the cross-stratum attack chain intact.

**Original contributions.**

1. A connected-systems layer model that frames the three domains as one architecture.
2. A unified, cross-stratum threat taxonomy that names the chains in which an attack at one layer enables an attack at another.
3. A layered defense reference model built on Design Principle 1.
4. A security-orchestration mapping that turns the virtualization layer into an active defender of constrained devices.

**Framework evaluation.** The proposed model is compared against established families of connected-system security models:

| Approach | Device (A) | Network (B) | Orchestration (C) | Cross-stratum coordination |
|---|---|---|---|---|
| Traditional WSN security | Yes | Partial | No | No |
| IoT and CPS security models | Yes | Yes | No | No |
| NFV and SDN security models | No | Partial | Yes | No |
| Proposed layered model | Yes | Yes | Yes | Yes |

---

## Repository structure

```text
securing-connected-systems-vol1/
├── README.md
├── LICENSE                      # MIT, applies to /code only
├── LICENSE-CC-BY-4.0.txt        # CC BY 4.0, applies to /paper and /figures
├── CITATION.cff                 # machine-readable citation metadata
├── .zenodo.json                 # Zenodo deposit metadata (root-level name required)
├── paper/
│   ├── 03_Monograph_1_Securing_Connected_Systems.pdf
│   └── 03_Monograph_1_Securing_Connected_Systems.docx
├── figures/
│   ├── vol1_fig1_cross_stratum_chain.svg / .png
│   ├── vol1_fig2_layered_reference_model.svg / .png
│   └── vol1_fig3_layer_model_architecture.svg / .png
└── code/
    ├── ece543-rsa/              # from-scratch RSA cryptosystem (Java)
    ├── ece545-ns3/             # TCP-under-congestion simulation (NS-3)
    └── ece442-sensorypi/       # encrypted IoT client/server, SensoryPi
```

---

## Companion code

The three implementation studies in the paper map to three code directories. Each holds the original coursework artifact plus a short README describing how to build and run it.

- **`code/ece543-rsa/`** A from-scratch RSA implementation in Java: primality generation and verification, public and private key-pair generation, and encryption and decryption. It exposes the full cryptographic lifecycle rather than calling a library, which is the basis for the paper's argument that key-generation cost dictates where public-key operations can run (Section 5.1).
- **`code/ece545-ns3/`** An NS-3 discrete-event simulation study of TCP congestion control, flow control, and reliable delivery under varying background traffic. It supports the paper's claim that fairness and reliability mechanisms are security-relevant, not only performance concerns (Section 6.2).
- **`code/ece442-sensorypi/`** An embedded client and server with encrypted communication over a constrained link, extended into SensoryPi, a smart security system performing on-device facial recognition and motion detection over an MQTT fabric. It is the concrete A-to-B bridge in the layered model (Section 8.1).

> Note: code is provided for reproducibility and study. Some artifacts originated as graduate coursework and have been cleaned for release. Each subfolder's README states its dependencies and known limitations.

---

## Figures

All three figures are provided as editable SVG and rendered PNG.

1. **Figure 1, Cross-Stratum Attack Chain.** How node capture, a routing attack, and a mis-placed defense compose into one undetected compromise.
2. **Figure 2, Layered Defense Reference Model.** Proportionate objectives, threats, and controls per stratum.
3. **Figure 3, Connected Systems Layer Model.** The three-stratum architecture, with data rising and policy and defense descending.

---

## How to cite

A machine-readable [`CITATION.cff`](CITATION.cff) is included; GitHub renders a "Cite this repository" button from it. Once the DOI is minted, replace the placeholder in `CITATION.cff`, `.zenodo.json`, and the paper.

**IEEE.** A. B. Palayil, "Securing Connected Systems: A Layered Security Framework for WSNs, IoT/CPS, and Virtualized Networks," Engineering-to-Research Monograph Series, vol. 1, 2026. doi: 10.5281/zenodo.20733453.

**BibTeX.**

```bibtex
@techreport{palayil2026securing,
  author      = {Palayil, Alan Biju},
  title       = {Securing Connected Systems: A Layered Security Framework for WSNs, IoT/CPS, and Virtualized Networks},
  institution = {Engineering-to-Research Monograph Series},
  number      = {Volume 1 of 10},
  year        = {2026},
  version     = {1.0},
  doi         = {10.5281/zenodo.20733453},
  url         = {https://doi.org/10.5281/zenodo.20733453}
}
```

---

## The Engineering-to-Research series

This is Volume 1 of a ten-volume program that turns a decade of engineering and research training into one coherent research identity, ending in explainable-AI governance.

| Vol | Title | Theme |
|----|----|----|
| 1 | Securing Connected Systems | Network and edge security |
| 2 | Computer Architecture for Security Engineers | Hardware security |
| 3 | Secure Systems Engineering | Secure coding and concurrency |
| 4 | Embedded-to-Edge-AI Reference Architecture | Edge AI |
| 5 | Teaching Offensive Security | Pedagogy and leadership |
| 6 | ERM and Cybersecurity Governance | Governance |
| 7 | Scalable Analytics for Enterprise Decisions | Big data |
| 8 | Data Mining for Financial Systems | Financial technology |
| 9 | Research Methods for Applied Computing | Methodology |
| 10 | From Embedded Systems to Explainable AI Governance | Synthesis capstone |

---

## Versioning

This repository follows the monograph version. Version 1.0 corresponds to the first Zenodo deposit. Future revisions will be released as new Zenodo versions under the same concept DOI, and tagged here with matching GitHub releases.

---

## License

- **Paper and figures** (`/paper`, `/figures`): Creative Commons Attribution 4.0 International (CC BY 4.0). See `LICENSE-CC-BY-4.0.txt`.
- **Code** (`/code`): MIT License. See `LICENSE`.

You may share and adapt the paper and figures with attribution, and use the code freely under MIT terms.

---

## Author

**Alan Biju Palayil**
Independent Researcher; Application Development Analyst, Financial Services; Doctoral Researcher, University of the Cumberlands.
ORCID: [0009-0004-8302-5090](https://orcid.org/0009-0004-8302-5090)
GitHub: [@AlanP13](https://github.com/AlanP13)

---

## Acknowledgments

The implementation studies originated in graduate coursework at the Illinois Institute of Technology: Computer Network Security (ECE 543) and Modern Internet Technologies (ECE 545), taught by Prof. Yu Cheng, and Internet of Things and Cyber-Physical Systems (ECE 442). All synthesis, analysis, framework development, and writing are the author's own and were written from scratch for publication.
